package com.zl.geekdesign.jvmtest;

import org.junit.Test;

import java.lang.ref.*;
import java.util.Map;
import java.util.WeakHashMap;

import static org.junit.Assert.*;

/**
 * 强软弱虚引用测试
 *
 * @author liusha
 * @date 2020/10/22
 */
public class RefrenceTest {

    /**
     * StrongReference 是 Java 的默认引用实现,  它会尽可能长时间的存活于 JVM 内， 当没有任何对象指向它时 GC 执行后将会被回收
     */
    @Test
    public void testStrong() {
        Object referent = new Object();

        /**
         * 通过赋值创建 StrongReference
         */
        Object strongReference = referent;

        assertSame(referent, strongReference);

        referent = null;
        System.gc();

        /**
         * StrongReference 在 GC 后不会被回收
         */
        assertNotNull(strongReference);
    }

    /**
     * WeakReference， 顾名思义,  是一个弱引用,  当所引用的对象在 JVM 内不再有强引用时, GC 后 weak reference 将会被自动回收
     */
    @Test
    public void testWeak() {
        Object referent = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(referent);

        assertSame(referent, weakReference.get());

        referent = null;
        System.gc();

        /**
         * 一旦没有指向 referent 的强引用, weak reference 在 GC 后会被自动回收
         */
        assertNull(weakReference.get());
    }

    /**
     * WeakHashMap 使用 WeakReference 作为 key， 一旦没有指向 key 的强引用, WeakHashMap 在 GC 后将自动删除相关的 entry
     */
    @Test
    public void testWeakMap() throws InterruptedException {
        Map<Object, Object> weakMap = new WeakHashMap<>();
        Object key = new Object();
        Object value = new Object();
        weakMap.put(key, value);

        assertTrue(weakMap.containsValue(value));

        key = null;
        System.gc();


        /**
         * 等待无效 entries 进入 ReferenceQueue 以便下一次调用 getTable 时被清理
         */
        Thread.sleep(1000);

        /**
         * 一旦没有指向 key 的强引用, WeakHashMap 在 GC 后将自动删除相关的 entry
         */
        assertFalse(weakMap.containsValue(value));

    }

    /**
     * SoftReference 于 WeakReference 的特性基本一致，
     * 最大的区别在于 SoftReference 会尽可能长的保留引用直到 JVM 内存不足时才会被回收(虚拟机保证),
     * 这一特性使得 SoftReference 非常适合缓存应用
     */
    @Test
    public void testSoft() {
        Object referent = new Object();
        SoftReference<Object> softReference = new SoftReference<>(referent);

        assertNotNull(softReference.get());

        referent = null;
        System.gc();

        /**
         *  soft references 只有在 jvm OutOfMemory 之前才会被回收, 所以它非常适合缓存应用
         */
        assertNotNull(softReference.get());
    }

    /**
     * Phantom Reference(幽灵引用) 与 WeakReference 和 SoftReference 有很大的不同,
     * 因为它的 get() 方法永远返回 null, 这也正是它名字的由来
     *
     * PhantomReference  有两个好处，
     * 其一， 它可以让我们准确地知道对象何时被从内存中删除，
     * 这个特性可以被用于一些特殊的需求中(例如 Distributed GC，  XWork 和 google-guice 中也使用 PhantomReference 做了一些清理性工作).
     *
     * 其二， 它可以避免 finalization 带来的一些根本性问题, 上文提到 PhantomReference 的唯一作用就是跟踪 referent 何时被 enqueue
     * 到 ReferenceQueue 中,  但是 WeakReference 也有对应的功能, 两者的区别到底在哪呢 ?
     * 这就要说到 Object 的 finalize 方法, 此方法将在 gc 执行前被调用, 如果某个对象重载了 finalize 方法并故意在方法内创建本身的强引
     * 用,  这将导致这一轮的 GC 无法回收这个对象并有可能引起任意次 GC， 最后的结果就是明明 JVM 内有很多 Garbage 却 OutOfMemory，
     * 使用 PhantomReference 就可以避免这个问题， 因为 PhantomReference 是在 finalize 方法执行后回收的，也就意味着此时已经不可能
     * 拿到原来的引用,  也就不会出现上述问题,  当然这是一个很极端的例子, 一般不会出现.
     */
    @Test
    public void testPhantom() {
        Object referent = new Object();
        PhantomReference<Object> phantomReference = new PhantomReference<>(referent, new ReferenceQueue<>());
        /**
         *  phantom reference 的 get 方法永远返回 null
         *
         *  PhantomReference 唯一的用处就是跟踪 referent  何时被 enqueue 到 ReferenceQueue 中
         *  (事实上 WeakReference & SoftReference 也可以有这个参数)
         */
        assertNull(phantomReference.get());
    }

    /**
     * 当一个 WeakReference 开始返回 null 时， 它所指向的对象已经准备被回收， 这时可以做一些合适的清理工作.
     * 将一个 ReferenceQueue 传给一个 Reference 的构造函数， 当对象被回收时， 虚拟机会自动将这个对象插入到 ReferenceQueue 中，
     * WeakHashMap 就是利用 ReferenceQueue 来清除 key 已经没有强引用的 entries.
     */
    @Test
    public void testReferenceQueue() throws InterruptedException {
        Object referent = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        WeakReference<Object> weakReference = new WeakReference<>(referent, referenceQueue);

        assertFalse(weakReference.isEnqueued());
        Reference<?> polled = referenceQueue.poll();
        assertNull(polled);

        referent = null;
        System.gc();

        /**
         * 等待一段时间才能成功进入ReferenceQueue中
         */
        Thread.sleep(1000);

        assertTrue(weakReference.isEnqueued());

        /**
         * 可以知道gc后被删除了
         */
        Reference<?> removed = referenceQueue.remove();
        assertNotNull(removed);
    }


}

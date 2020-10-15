package com.zl.geekdesign.observer.eventbus;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

import java.util.List;
import java.util.concurrent.Executors;

/**
 * 基于Google Guava EventBus重新设计（simple包中是从零编写的观察者模式）
 *
 * 相似：
 * 1. 都需要定义Observer，并且通过register()函数注册观察者
 * 2. 都需要在完成通用的注册功能后，调用post()或者notify()方法通知到每一个观察者实现类进行操作。
 *
 * 区别：
 * 1. EventBus可以简洁的定义阻塞或者非阻塞的观察者；simple包中的需要手动使用多线程来定义阻塞或者非阻塞；
 * 2. eventBus自带一个接收观察者的list，不需要手动去定义；
 * 3. 因为2的原因，eventBus在通知观察者时不需要遍历list去通知，直接调用eventBus.post()即可。
 * 4. 观察者实现类中只需要在对应接收方法上添加@Subscribe即可。
 *
 */
public class UserService2 {

    private EventBus eventBus;
    private static final int DEFAULT_EVENTBUS_THREAD_POLL_SIZE = 20;

    public UserService2() {
        // eventBus = new EventBus(); // 同步阻塞模式
        eventBus = new AsyncEventBus(Executors.newFixedThreadPool(DEFAULT_EVENTBUS_THREAD_POLL_SIZE));
    }

    public void setRegObserver(List<Object> observers) {
        observers.forEach(v -> eventBus.register(v));
    }

    public Long register(String telephone, String password) {
        // 注册功能，注册成功返回userId
        Long userId = 1L;

        // 将注册成功的用户id放入eventBus
        eventBus.post(userId);

        return userId;
    }



}
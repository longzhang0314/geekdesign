package com.zl.geekdesign.observer.simple;

/**
 * 观察者
 */
public interface UserObserver {

    /**
     * 接受到注册成功通知
     *
     * @param obj
     */
    void notify(Object obj);
}

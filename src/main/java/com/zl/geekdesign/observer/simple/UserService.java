package com.zl.geekdesign.observer.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * 被观察者
 */
public class UserService {

    // 可以利用框架自动注入
    private List<UserObserver> observerList = new ArrayList<>();

    // 一次注入，之后不会再更改
    public void setObserverList(List<UserObserver> userObservers) {
        observerList.addAll(userObservers);
    }

    public void register(int userId) {
        // ... 注册成功
        for (UserObserver userObserver : observerList) {
            Object msg = new Object();
            userObserver.notify(msg);
        }
    }
}

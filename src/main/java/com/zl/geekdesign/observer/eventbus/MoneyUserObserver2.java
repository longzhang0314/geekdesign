package com.zl.geekdesign.observer.eventbus;

import com.google.common.eventbus.Subscribe;

public class MoneyUserObserver2 {

    @Subscribe
    public void handleRegSuccess(Long userId) {
        // 发放新人奖励...

        // ...
    }
}

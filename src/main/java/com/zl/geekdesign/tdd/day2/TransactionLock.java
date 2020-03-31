package com.zl.geekdesign.tdd.day2;

/**
 * Create by zhanglong on 2020/3/24
 */
public class TransactionLock {

    public boolean lock(String id) {
        return RedisDistributedLock.getSingletonIntance().lockTransction(id);
    }

    public void unlock(String id) {
        RedisDistributedLock.getSingletonIntance().unlockTransction(id);
    }
}

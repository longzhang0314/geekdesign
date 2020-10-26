package com.zl.geekdesign.tdd.day2;

/**
 * Create by zhanglong on 2020/3/24
 */
public class RedisDistributedLock {

    private RedisDistributedLock() {
    }

    public boolean lockTransction(String id) {
        //...具体加锁逻辑

        return false;
    }

    public void unlockTransction(String id) {
        //...具体解锁逻辑
    }

    private static class SingleHolder {
        private static final RedisDistributedLock REDIS_DISTRIBUTED_LOCK = new RedisDistributedLock();
    }

    public static RedisDistributedLock getSingletonIntance() {
        return SingleHolder.REDIS_DISTRIBUTED_LOCK;
    }


}

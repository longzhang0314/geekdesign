package com.zl.geekdesign.tdd.day2;

import java.util.Date;

/**
 * 未决行为Demo
 * 重构前
 * Create by zhanglong on 2020/3/24
 */
public class Demo {

    public long caculateDelayDays(Date dueTime) {
        if (afterCurrentTime(dueTime)) {
            return 0;
        }
        return delayDays(dueTime);
    }

    protected boolean afterCurrentTime(Date dueTime) {
        return dueTime.getTime() >= System.currentTimeMillis();
    }

    protected long delayDays(Date dueTime) {
        long delayTime = System.currentTimeMillis() - dueTime.getTime();
        long delayDays = delayTime / 86400;
        return delayDays;
    }

}

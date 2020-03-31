package com.zl.geekdesign.tdd.day2;

import java.util.Date;

/**
 * 未决行为Demo
 * 重构前
 * Create by zhanglong on 2020/3/24
 */
public class Demo1 {

    public long caculateDelayDays(Date dueTime) {
        long currentTimestamp = System.currentTimeMillis();
        if (dueTime.getTime() >= currentTimestamp) {
            return 0;
        }
        long delayTime = currentTimestamp - dueTime.getTime();
        long delayDays = delayTime / 86400;
        return delayDays;
    }
}

package com.zl.geekdesign.tdd.day2;

import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * 未决行为Demo
 * 单元测试
 * Create by zhanglong on 2020/3/24
 */
public class DemoTest {

    @Test
    public void testCaculateDelayDays() {
        Demo demo = new Demo() {
            @Override
            protected boolean afterCurrentTime(Date dueTime) {
                return super.afterCurrentTime(dueTime);
            }

            @Override
            protected long delayDays(Date dueTime) {
                return super.delayDays(dueTime);
            }

        };
    }
}

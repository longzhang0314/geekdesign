package com.zl.geekdesign.ioc.testcase;

/**
 * Create by zhanglong on 2020/3/17
 */
public abstract class TestCase {

    public abstract boolean doTest();

    public void run() {
        if (doTest()) {
            System.out.println("Test sucessed");
        } else {
            System.out.println("Test failed");
        }
    }

}

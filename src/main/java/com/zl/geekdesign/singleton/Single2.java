package com.zl.geekdesign.singleton;

/**
 * Create by zhanglong on 2020/3/4
 */
public class Single2 {

    private static class Inner {
        private static final Single2 single2 = new Single2();
    }

    private Single2(){}

    public static Single2 getInstance() {
        return Inner.single2;
    }
}

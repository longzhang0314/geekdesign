package com.zl.geekdesign.singleton;

/**
 * Create by zhanglong on 2020/3/4
 */
public class Single3 {
    private Single3() {}

    private static volatile Single3 single3;

    public static Single3 getInstance() {
        if(single3==null) {
            synchronized (Single3.class) {
                if(single3==null) {
                    single3 = new Single3();
                }
            }
        }
        return single3;
    }

}

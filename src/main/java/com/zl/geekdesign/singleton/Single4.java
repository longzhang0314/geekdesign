package com.zl.geekdesign.singleton;

/**
 * Create by zhanglong on 2020/3/4
 */
public class Single4 {
    private Single4() {
    }

    private static Single4 single4;

    public static Single4 getInstance() {
        Single4 temp = single4;
        if (temp == null) {
            synchronized (Single4.class) {
                if (temp == null) {
                    temp = new Single4();
                    single4 = temp;
                }
            }
        }
        return single4;
    }
}

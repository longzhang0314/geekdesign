package com.zl.geekdesign.chain.type1;

/**
 * @author liusha
 * @date 2020/10/15
 */
public class HandlerB extends Handler {

    @Override
    public void handle() {
        boolean handled = false;
        // ...
        if (!handled && successor != null) {
            successor.handle();
        }
    }
}

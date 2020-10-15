package com.zl.geekdesign.chain.type1;

/**
 * @author liusha
 * @date 2020/10/15
 */
public class HandlerA extends Handler {

    @Override
    public void handle() {
        boolean handled = false;
        // ...
        // 如果能处理，就不会继续往下传递请求
        if (!handled && successor != null) {
            successor.handle();
        }
    }
}

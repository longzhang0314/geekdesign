package com.zl.geekdesign.chain.type1;

/**
 * @author liusha
 * @date 2020/10/15
 */
public class HandlerChain {

    private Handler head;
    private Handler tail;

    public void addHandler(Handler handler) {
        handler.setSuccessor(null);
        if (head == null) {
            head = handler;
            tail = handler;
            return;
        }
        tail.setSuccessor(handler);
        tail = handler;
    }

    public void handle() {
        if (head != null) {
            head.handle();
        }
    }


}

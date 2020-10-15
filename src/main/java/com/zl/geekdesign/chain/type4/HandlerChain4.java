package com.zl.geekdesign.chain.type4;

/**
 * @author liusha
 * @date 2020/10/15
 */
public class HandlerChain4 {

    private Handler4 head;
    private Handler4 tail;

    public void addHandler(Handler4 handler4) {
        handler4.setSuccessor(null);
        if (head == null) {
            head = handler4;
            tail = handler4;
            return;
        }
        tail.setSuccessor(handler4);
        tail = handler4;
    }

    public void handler() {
        if (head != null) {
            head.handler();
        }
    }
}

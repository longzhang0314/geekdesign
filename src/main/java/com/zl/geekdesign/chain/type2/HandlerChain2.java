package com.zl.geekdesign.chain.type2;

/**
 * @author liusha
 * @date 2020/10/15
 */
public class HandlerChain2 {

    private Handler2 head;
    private Handler2 tail;

    public void addHandler(Handler2 handler2) {
        handler2.setSuccessor(null);
        if (head == null) {
            head = handler2;
            tail = handler2;
            return;
        }
        tail.setSuccessor(handler2);
        tail = handler2;
    }

    public void handle() {
        if (head != null) {
            head.handle();
        }
    }
}

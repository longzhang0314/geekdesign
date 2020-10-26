package com.zl.geekdesign.chain.type2;

/**
 * @author liusha
 * @date 2020/10/15
 */
public abstract class Handler2 {
    private Handler2 successor;

    public void setSuccessor(Handler2 successor) {
        this.successor = successor;
    }

    public void handle() {
        boolean handler = doHandle();
        if (!handler && successor != null) {
            successor.handle();
        }
    }

    protected abstract boolean doHandle();
}

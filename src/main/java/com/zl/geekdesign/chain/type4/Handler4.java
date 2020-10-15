package com.zl.geekdesign.chain.type4;

/**
 * @author liusha
 * @date 2020/10/15
 */
public abstract class Handler4 {

    private Handler4 successor;

    public void setSuccessor(Handler4 successor) {
        this.successor = successor;
    }

    public void handler() {
        doHandler();
        if (successor != null) {
            successor.handler();
        }
    }

    protected abstract void doHandler();

}

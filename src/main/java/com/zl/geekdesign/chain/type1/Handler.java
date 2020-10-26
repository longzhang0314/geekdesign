package com.zl.geekdesign.chain.type1;

/**
 * @author longzhang0314
 * @date 2020/10/15
 */
public abstract class Handler {
    protected Handler successor;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public abstract void handle();
}

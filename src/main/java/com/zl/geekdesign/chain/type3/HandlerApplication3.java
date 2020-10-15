package com.zl.geekdesign.chain.type3;

/**
 * @author liusha
 * @date 2020/10/15
 */
public class HandlerApplication3 {

    public static void main(String[] args) {
        HandlerChain3 chain3 = new HandlerChain3();
        chain3.addHandler(new HandlerA3());
        chain3.addHandler(new HandlerA3());
        chain3.handler();
    }
}

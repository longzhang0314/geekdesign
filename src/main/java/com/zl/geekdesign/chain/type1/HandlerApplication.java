package com.zl.geekdesign.chain.type1;

/**
 * 使用说明
 *
 * 这种方式通过继承抽象类以及增加一个链表可以实现，但是不够优雅
 * 因为每增加一种新的Handler, 处理完自己的逻辑以后还需要处理successor.handle()的逻辑，很容易忘记
 *
 * @author liusha
 * @date 2020/10/15
 */
public class HandlerApplication {

    public static void main(String[] args) {
        HandlerChain chain = new HandlerChain();
        chain.addHandler(new HandlerA());
        chain.addHandler(new HandlerB());
        chain.handle();
    }
}

package com.zl.geekdesign.ioc.messagesend.demo2;

/**
 * Create by zhanglong on 2020/3/17
 */
public class InboxSender implements IMessageSender {
    @Override
    public void send(String cellphone, String message) {
        //...具体发送逻辑
    }
}

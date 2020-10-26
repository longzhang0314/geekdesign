package com.zl.geekdesign.ioc.messagesend.demo2;

/**
 * 依赖注入
 * Create by zhanglong on 2020/3/17
 */
public class Notification3 {

    private IMessageSender iMessageSender;

    public Notification3(IMessageSender iMessageSender) {
        this.iMessageSender = iMessageSender;
    }

    public void sendMessage(String cellphone, String message) {
        this.iMessageSender.send(cellphone, message);
    }

    public static void main(String[] args) {
        //提供扩展性
        //但此处创建对象的工作依然是硬编码，所以之后产生了依赖注入框架
        IMessageSender iMessageSender = new SmsSender();
        Notification3 notification3 = new Notification3(iMessageSender);
        notification3.sendMessage("cell", "mess");
    }
}

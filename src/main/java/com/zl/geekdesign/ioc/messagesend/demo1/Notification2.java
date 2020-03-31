package com.zl.geekdesign.ioc.messagesend.demo1;

/**
 * 依赖注入方式
 * Create by zhanglong on 2020/3/17
 */
public class Notification2 {

    private MessageSender messageSender;

    public Notification2(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void sendMessage(String cellPhone,String message) {
        //...校验逻辑
        this.messageSender.send(cellPhone,message);
    }

    public static void main(String[] args) {
        //提前创建好messageSender对象，提高了代码的扩展性
        MessageSender messageSender = new MessageSender();
        Notification2 notification2 = new Notification2(messageSender);
        notification2.sendMessage("cell","mess");
    }

}

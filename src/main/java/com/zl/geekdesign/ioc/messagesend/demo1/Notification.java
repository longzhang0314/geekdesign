package com.zl.geekdesign.ioc.messagesend.demo1;

/**
 * 非依赖注入方式
 * Create by zhanglong on 2020/3/17
 */
public class Notification {

    private MessageSender messageSender;

    public Notification() {
        this.messageSender = new MessageSender();
    }

    public void sendMessage(String cellPhone, String message) {
        //...校验逻辑
        this.messageSender.send(cellPhone, message);
    }

    public static void main(String[] args) {
        //无法对MessageSender进行扩展
        Notification notification = new Notification();
        notification.sendMessage("cell", "mess");
    }
}

package com.zl.geekdesign.alert;

/**
 * Create by zhanglong on 2020/3/4
 */
public class ErrorAlertHandler extends AlertHandler {
    public ErrorAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        System.out.println("Error check start");
    }
}

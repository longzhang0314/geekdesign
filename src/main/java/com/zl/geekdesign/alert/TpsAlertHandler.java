package com.zl.geekdesign.alert;

/**
 * Create by zhanglong on 2020/3/4
 */
public class TpsAlertHandler extends AlertHandler {
    public TpsAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        System.out.println("tps check start");
    }
}

package com.zl.geekdesign.alert;

/**
 * Create by zhanglong on 2020/3/4
 */
public class ApplicationContext {
    private AlertRule alertRule;
    private Notification notification;
    private Alert alert;

    public void initalBeans() {
        alertRule = new AlertRule();
        notification = new Notification();
        alert = new Alert();
        alert.addAlertHandler(new TpsAlertHandler(alertRule, notification));
        alert.addAlertHandler(new ErrorAlertHandler(alertRule, notification));
    }

    public Alert getAlert() {
        return alert;
    }


    private static final ApplicationContext instance = new ApplicationContext();

    private ApplicationContext() {
        this.initalBeans();
    }

    public static ApplicationContext getInstance() {
        return instance;
    }

}

class Demo {
    public static void main(String[] args) {
        ApiStatInfo apiStatInfo = new ApiStatInfo();
        ApplicationContext.getInstance().getAlert().check(apiStatInfo);
    }
}


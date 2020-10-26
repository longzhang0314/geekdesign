package com.zl.geekdesign.alert;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by zhanglong on 2020/3/4
 */
public class Alert {
    private List<AlertHandler> alertHandlers = new ArrayList<>();

    public void addAlertHandler(AlertHandler alertHandler) {
        this.alertHandlers.add(alertHandler);
    }

    public void check(ApiStatInfo apiStatInfo) {
        for (AlertHandler alertHandler : alertHandlers) {
            alertHandler.check(apiStatInfo);
        }
    }

}

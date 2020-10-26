package com.zl.geekdesign.performancecounter.version201;

import com.google.gson.Gson;
import com.zl.geekdesign.performancecounter.bo.RequestStat;

import java.util.Map;

/**
 * Create by zhanglong on 2020/3/27
 */
public class ConsoleViewer implements StatViewer {
    @Override
    public void optput(Map<String, RequestStat> requestStat, long startTimeInMillis, long endTimeInMillis) {
        System.out.println("Time Span: [" + startTimeInMillis + ", " + endTimeInMillis + "]");
        Gson gson = new Gson();
        System.out.println(gson.toJson(requestStat));
    }
}

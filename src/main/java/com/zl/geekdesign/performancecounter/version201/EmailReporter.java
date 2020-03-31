package com.zl.geekdesign.performancecounter.version201;

import com.zl.geekdesign.performancecounter.bo.RequestInfo;
import com.zl.geekdesign.performancecounter.bo.RequestStat;

import java.util.*;

/**
 * Create by zhanglong on 2020/3/27
 */
public class EmailReporter {
    private static final Long DAY_HOURS_IN_SECONDS = 86400L;

    private MetricsStorage metricsStorage;
    private Aggregator aggregator;
    private StatViewer viewer;

    public EmailReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatViewer viewer) {
        this.metricsStorage = metricsStorage;
        this.aggregator = aggregator;
        this.viewer = viewer;
    }

    public void startDailyReport() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date firstTime = calendar.getTime();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                long durationInMillis = DAY_HOURS_IN_SECONDS * 1000;
                long endTimeMillis = System.currentTimeMillis();
                long startTimeMillis = endTimeMillis - durationInMillis;
                Map<String, List<RequestInfo>> requestInfos = metricsStorage.getRequestInfos(startTimeMillis, endTimeMillis);
                Map<String, RequestStat> stats = aggregator.aggregate(requestInfos, durationInMillis);
                viewer.optput(stats, startTimeMillis, endTimeMillis);
            }
        }, firstTime, DAY_HOURS_IN_SECONDS * 1000);
    }
}

package com.zl.geekdesign.performancecounter.version201;

import com.zl.geekdesign.performancecounter.bo.RequestInfo;
import com.zl.geekdesign.performancecounter.bo.RequestStat;

import java.util.*;

/**
 * 第二版：根据原始数据，计算得到统计数据
 * Create by zhanglong on 2020/3/27
 */
public class Aggregator {

    public Map<String, RequestStat> aggregate(Map<String, List<RequestInfo>> requestInfos, long durationMillis) {
        Map<String, RequestStat> requestStats = new HashMap<>();
        for (Map.Entry<String, List<RequestInfo>> entry : requestInfos.entrySet()) {
            String apiName = entry.getKey();
            List<RequestInfo> requestInfosPerApis = entry.getValue();
            RequestStat requestStat = doAggregate(requestInfosPerApis, durationMillis);
            requestStats.put(apiName, requestStat);
        }
        return requestStats;
    }

    private RequestStat doAggregate(List<RequestInfo> requestInfos, long durationMillis) {
        List<Double> respTimes = new ArrayList<>();
        for (RequestInfo requestInfo : requestInfos) {
            double respTime = requestInfo.getResponseTime();
            respTimes.add(respTime);
        }

        RequestStat requestStat = new RequestStat();
        requestStat.setMaxResponseTime(max(respTimes));
        requestStat.setMinResponseTime(min(respTimes));
        requestStat.setAvgResponseTime(avg(respTimes));
        requestStat.setP999ResponseTime(percentile999(respTimes));
        requestStat.setP99ResponseTime(percentile99(respTimes));
        requestStat.setCount(count(respTimes));
        requestStat.setTps(tps(respTimes, durationMillis));
        return requestStat;
    }

    private long tps(List<Double> respTimes, long durationMillis) {
        return count(respTimes) / durationMillis * 1000;
    }

    private long count(List<Double> respTimes) {
        long count = 0;
        for (double d : respTimes) {
            count++;
        }
        return count;
    }

    private double percentile99(List<Double> respTimes) {
        Collections.sort(respTimes);
        return count(respTimes) * 0.99;
    }

    private double percentile999(List<Double> respTimes) {
        Collections.sort(respTimes);
        return count(respTimes) * 0.999;
    }

    private double avg(List<Double> respTimes) {
        long count = count(respTimes);
        return count == 0 ? 0 : sum(respTimes) / count;
    }

    private double sum(List<Double> respTimes) {
        double sum = 0;
        for (double d : respTimes) {
            sum += d;
        }
        return sum;
    }

    private double min(List<Double> respTimes) {
        double min = Double.MAX_VALUE;
        for (double d : respTimes) {
            min = Math.min(min, d);
        }
        return min;
    }

    private double max(List<Double> respTimes) {
        double max = Double.MIN_VALUE;
        for (double d : respTimes) {
            max = Math.max(max, d);
        }
        return max;
    }
}

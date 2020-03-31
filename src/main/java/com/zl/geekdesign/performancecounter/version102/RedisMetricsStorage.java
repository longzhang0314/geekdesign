package com.zl.geekdesign.performancecounter.version102;

import com.zl.geekdesign.performancecounter.bo.RequestInfo;

import java.util.List;
import java.util.Map;

/**
 * 使用Redis存储
 * Create by zhanglong on 2020/3/27
 */
public class RedisMetricsStorage implements MetricsStorage {
    @Override
    public void saveRequestInfo(RequestInfo requestInfo) {
        //...
    }

    @Override
    public List<RequestInfo> getRequestInfos(String apiName, long startTimeInMillis, long endTimeInMillis) {
        return null;
    }

    @Override
    public Map<String, List<RequestInfo>> getRequestInfos(long startTimeInMillis, long endTimeInMillis) {
        return null;
    }
}

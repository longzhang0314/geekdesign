package com.zl.geekdesign.performancecounter.version102;

import com.zl.geekdesign.performancecounter.bo.RequestInfo;

import java.util.List;
import java.util.Map;

/**
 * 存储器
 * Create by zhanglong on 2020/3/27
 */
public interface MetricsStorage {
    void saveRequestInfo(RequestInfo requestInfo);

    List<RequestInfo> getRequestInfos(String apiName, long startTimeInMillis, long endTimeInMillis);

    Map<String, List<RequestInfo>> getRequestInfos(long startTimeInMillis, long endTimeInMillis);
}

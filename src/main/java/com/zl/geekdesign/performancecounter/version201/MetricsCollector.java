package com.zl.geekdesign.performancecounter.version201;

import com.zl.geekdesign.performancecounter.bo.RequestInfo;
import org.springframework.util.StringUtils;

/**
 * 采集器
 * Create by zhanglong on 2020/3/27
 */
public class MetricsCollector {
    private MetricsStorage metricsStorage;//基于接口

    public MetricsCollector() {
        this.metricsStorage = new RedisMetricsStorage();
    }


    //依赖注入
    public MetricsCollector(MetricsStorage metricsStorage) {
        this.metricsStorage = metricsStorage;
    }

    public void recordRequest(RequestInfo requestInfo) {
        if (requestInfo == null || StringUtils.isEmpty(requestInfo)) return;
        metricsStorage.saveRequestInfo(requestInfo);
    }
}

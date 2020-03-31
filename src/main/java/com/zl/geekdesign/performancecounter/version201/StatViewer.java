package com.zl.geekdesign.performancecounter.version201;

import com.zl.geekdesign.performancecounter.bo.RequestStat;

import java.util.Map;

/**
 * 统计数据显示到终端
 * Create by zhanglong on 2020/3/27
 */
public interface StatViewer {
    void optput(Map<String, RequestStat> requestStat, long startTimeInMillis, long endTimeInMillis);
}

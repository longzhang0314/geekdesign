package com.zl.geekdesign.performancecounter.bo;

/**
 * 数据采集对象
 * Create by zhanglong on 2020/3/27
 */
public class RequestInfo {
    private String apiName;
    private double responseTime;
    private double timestamp;

    public RequestInfo(String apiName, double responseTime, double timestamp) {
        this.apiName = apiName;
        this.responseTime = responseTime;
        this.timestamp = timestamp;
    }

    public RequestInfo() {
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public double getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(double responseTime) {
        this.responseTime = responseTime;
    }

    public double getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(double timestamp) {
        this.timestamp = timestamp;
    }
}

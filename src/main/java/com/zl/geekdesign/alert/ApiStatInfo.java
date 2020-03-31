package com.zl.geekdesign.alert;

/**
 * Create by zhanglong on 2020/3/4
 */
public class ApiStatInfo {
    private String api;
    private long requestCount;
    private long errorCount;
    private long durationOfSeconds;

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public long getRequestCount() {
        return requestCount;
    }

    public void setRequestCount(long requestCount) {
        this.requestCount = requestCount;
    }

    public long getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(long errorCount) {
        this.errorCount = errorCount;
    }

    public long getDurationOfSeconds() {
        return durationOfSeconds;
    }

    public void setDurationOfSeconds(long durationOfSeconds) {
        this.durationOfSeconds = durationOfSeconds;
    }

    public ApiStatInfo() {

    }

    public ApiStatInfo(String api, long requestCount, long errorCount, long durationOfSeconds) {

        this.api = api;
        this.requestCount = requestCount;
        this.errorCount = errorCount;
        this.durationOfSeconds = durationOfSeconds;
    }
}

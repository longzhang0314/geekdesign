package com.zl.geekdesign.auth.domain;

import java.util.Map;

/**
 * url相关
 * Create by zhanglong on 2020/3/3
 */
public class ApiRequest {

    private String appId;
    private String baseUrl;
    private long createTime;
    private String token;

    public ApiRequest(String appId, String baseUrl, long createTime, String token) {
        this.appId = appId;
        this.baseUrl = baseUrl;
        this.createTime = createTime;
        this.token = token;
    }

    public static ApiRequest buildFromUrl(String url) {
        //TODO 从url中解析出每个元素
        Map<String,String> param = null;
        ApiRequest apiRequest = new ApiRequest(param.get("appId"),param.get("baseUrl"),
                Long.parseLong(param.get("createTime")),param.get("token"));
        return apiRequest;
    }

    public String getAppId() {
        return appId;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public long getCreateTime() {
        return createTime;
    }

    public String getToken() {
        return token;
    }
}

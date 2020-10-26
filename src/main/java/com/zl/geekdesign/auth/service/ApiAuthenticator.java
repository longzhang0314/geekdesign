package com.zl.geekdesign.auth.service;


import com.zl.geekdesign.auth.domain.ApiRequest;

/**
 * Create by zhanglong on 2020/3/3
 */
public interface ApiAuthenticator {
    void auth(String url);

    void auth(ApiRequest apiRequest);
}

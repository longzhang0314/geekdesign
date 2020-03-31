package com.zl.geekdesign.auth.service.impl;


import com.zl.geekdesign.auth.domain.ApiRequest;
import com.zl.geekdesign.auth.domain.AuthToken;
import com.zl.geekdesign.auth.service.ApiAuthenticator;
import com.zl.geekdesign.auth.service.CredentialStorage;

/**
 * Create by zhanglong on 2020/3/3
 */
public class DefaultApiAuthenticatorImpl implements ApiAuthenticator {


    private CredentialStorage credentialStorage;

    public DefaultApiAuthenticatorImpl(CredentialStorage credentialStorage) {
        this.credentialStorage = credentialStorage;
    }

    public DefaultApiAuthenticatorImpl() {
        this.credentialStorage = new DefaultCredentialStorageImpl();
    }

    @Override
    public void auth(String url) {
        ApiRequest apiRequest = ApiRequest.buildFromUrl(url);
        auth(apiRequest);
    }

    @Override
    public void auth(ApiRequest apiRequest) {
        String appId = apiRequest.getAppId();
        String baseUrl = apiRequest.getBaseUrl();
        long createTime = apiRequest.getCreateTime();
        String token = apiRequest.getToken();

        AuthToken clientToken = new AuthToken(token, createTime);
        //判断token失效
        if (clientToken.isExpired()) {
            throw new RuntimeException("Token is expired.");
        }

        AuthToken serverToken = AuthToken.create(appId, "", createTime, baseUrl);
        //token一致性
        if (!serverToken.match(clientToken)) {
            throw new RuntimeException("Token verfication failed.");
        }
    }
}

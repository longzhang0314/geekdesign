package com.zl.geekdesign.auth.service.impl;


import com.zl.geekdesign.auth.service.CredentialStorage;

/**
 * Create by zhanglong on 2020/3/3
 */
public class DefaultCredentialStorageImpl implements CredentialStorage {
    @Override
    public String getPasswordByAppId(String appId) {
        return "123456";
    }
}

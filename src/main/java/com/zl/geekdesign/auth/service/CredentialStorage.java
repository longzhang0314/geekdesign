package com.zl.geekdesign.auth.service;

/**
 * Create by zhanglong on 2020/3/3
 */
public interface CredentialStorage {

    String getPasswordByAppId(String appId);
}

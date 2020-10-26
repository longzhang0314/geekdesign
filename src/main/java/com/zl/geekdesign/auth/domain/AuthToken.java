package com.zl.geekdesign.auth.domain;

/**
 * token相关
 * Create by zhanglong on 2020/3/3
 */
public class AuthToken {

    private static final long DEFAULT_EXPIRED_TIME = 1 * 60 * 1000;
    private String token;
    private long createTime;
    private long expiredTime = DEFAULT_EXPIRED_TIME;

    public AuthToken(String token, long createTime) {
        this.token = token;
        this.createTime = createTime;
    }

    public AuthToken(String token, long createTime, long expiredTime) {
        this.token = token;
        this.createTime = createTime;
        this.expiredTime = expiredTime;
    }


    public static AuthToken create(String appId, String password, long createTime, String baseUrl) {
        String str = new StringBuilder(baseUrl).append(appId).append(password).append(createTime).toString();
        String token = "str加密";
        return new AuthToken(token, createTime);
    }


    public String getToken() {
        return token;
    }

    public boolean isExpired() {
        return createTime + expiredTime < System.currentTimeMillis();
    }

    public boolean match(AuthToken authToken) {
        return token.equals(authToken.getToken());
    }

}

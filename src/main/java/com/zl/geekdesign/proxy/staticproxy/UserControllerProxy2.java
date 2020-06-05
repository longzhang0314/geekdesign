package com.zl.geekdesign.proxy.staticproxy;

import com.zl.geekdesign.performancecounter.bo.RequestInfo;
import com.zl.geekdesign.performancecounter.version201.MetricsCollector;
import com.zl.geekdesign.performancecounter.version201.RedisMetricsStorage;
import com.zl.geekdesign.performancecounter.vo.UserVo;

/**
 * 继承自被代理类
 * Create by zhanglong on 2020/6/5
 */
public class UserControllerProxy2 extends UserController {
    private MetricsCollector metricsCollector;

    public UserControllerProxy2() {
        this.metricsCollector = new MetricsCollector(new RedisMetricsStorage());
    }

    @Override
    public UserVo login(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();
        UserVo userVo = super.login(telephone, password);
        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;
        RequestInfo requestInfo = new RequestInfo("login", responseTime, startTimestamp);
        metricsCollector.recordRequest(requestInfo);
        return userVo;
    }

    @Override
    public UserVo register(UserVo user) {
        long startTimestamp = System.currentTimeMillis();
        UserVo userVo = super.register(user);
        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;
        RequestInfo requestInfo = new RequestInfo("register", responseTime, startTimestamp);
        metricsCollector.recordRequest(requestInfo);
        return userVo;
    }


}

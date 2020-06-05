package com.zl.geekdesign.proxy.staticproxy;

import com.zl.geekdesign.performancecounter.bo.RequestInfo;
import com.zl.geekdesign.performancecounter.version201.MetricsCollector;
import com.zl.geekdesign.performancecounter.version201.RedisMetricsStorage;
import com.zl.geekdesign.performancecounter.vo.UserVo;
import com.zl.geekdesign.proxy.IUserController;

/**
 * 静态代理1 - 实现同一个接口
 * Create by zhanglong on 2020/6/5
 */
public class UserControllerProxy implements IUserController {
    private MetricsCollector metricsCollector;
    private UserController userController;

    public UserControllerProxy(UserController userController) {
        this.metricsCollector = new MetricsCollector(new RedisMetricsStorage());
        this.userController = userController;
    }


    @Override
    public UserVo register(UserVo user) {
        long startTime = System.currentTimeMillis();

        UserVo register = this.userController.register(user);

        long endTime = System.currentTimeMillis();
        long responseTime = endTime - startTime;
        RequestInfo requestInfo = new RequestInfo("register", responseTime, startTime);
        metricsCollector.recordRequest(requestInfo);

        return register;
    }


    @Override
    public UserVo login(String telephone, String password) {
        long startTime = System.currentTimeMillis();

        UserVo register = this.userController.login(telephone, password);

        long endTime = System.currentTimeMillis();
        long responseTime = endTime - startTime;
        RequestInfo requestInfo = new RequestInfo("login", responseTime, startTime);
        metricsCollector.recordRequest(requestInfo);

        return register;
    }
}

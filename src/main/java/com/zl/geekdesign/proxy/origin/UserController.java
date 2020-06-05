package com.zl.geekdesign.proxy.origin;

import com.zl.geekdesign.performancecounter.version101.Metrics;
import com.zl.geekdesign.performancecounter.vo.UserVo;
import com.zl.geekdesign.proxy.IUserController;

import java.util.concurrent.TimeUnit;

/**
 * Create by zhanglong on 2020/3/27
 */
public class UserController {

    private Metrics metrics = new Metrics();

    public UserController() {
        metrics.startRepeatedReport(60, TimeUnit.SECONDS);
    }

    public UserVo register(UserVo user) {
        long startTimestamps = System.currentTimeMillis();
        metrics.recordTimestamp("register", startTimestamps);
        //...
        long respTime = System.currentTimeMillis();
        metrics.recordResponseTime("register", respTime);

        return null;
    }

    public UserVo login(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();
        metrics.recordTimestamp("login", startTimestamp);
        //...
        long respTime = System.currentTimeMillis() - startTimestamp;
        metrics.recordResponseTime("login", respTime);

        return null;
    }

}

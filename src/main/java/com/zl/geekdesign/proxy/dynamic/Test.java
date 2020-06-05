package com.zl.geekdesign.proxy.dynamic;

import com.zl.geekdesign.proxy.IUserController;
import com.zl.geekdesign.proxy.staticproxy.UserController;

/**
 * Create by zhanglong on 2020/6/5
 */
public class Test {

    public static void main(String[] args) {
        MetricCollectProxy proxy = new MetricCollectProxy();
        IUserController userController = (IUserController) proxy.createProxy(new UserController());

    }
}

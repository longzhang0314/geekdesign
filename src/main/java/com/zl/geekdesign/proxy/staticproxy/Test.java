package com.zl.geekdesign.proxy.staticproxy;

import com.zl.geekdesign.proxy.IUserController;

/**
 * Create by zhanglong on 2020/6/5
 */
public class Test {
    public static void main(String[] args) {
        // 调用方式1
        IUserController userController = new UserControllerProxy(new UserController());

        // 方式2
        UserController controller = new UserControllerProxy2();
    }
}

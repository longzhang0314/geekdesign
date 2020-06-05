package com.zl.geekdesign.proxy.staticproxy;

import com.zl.geekdesign.performancecounter.vo.UserVo;
import com.zl.geekdesign.proxy.IUserController;

/**
 * Create by zhanglong on 2020/6/5
 */
public class UserController implements IUserController {

    @Override
    public UserVo register(UserVo user) {
        // ...具体注册
        return null;
    }

    @Override
    public UserVo login(String telephone, String password) {
        // ...具体登录
        return null;
    }
}

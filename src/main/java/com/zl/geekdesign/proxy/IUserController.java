package com.zl.geekdesign.proxy;

import com.zl.geekdesign.performancecounter.vo.UserVo;

/**
 * Create by zhanglong on 2020/6/5
 */
public interface IUserController {

    UserVo register(UserVo user);

    UserVo login(String telephone, String password);
}

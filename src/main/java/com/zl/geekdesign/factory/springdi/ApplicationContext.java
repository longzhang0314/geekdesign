package com.zl.geekdesign.factory.springdi;

/**
 * Create by zhanglong on 2020/4/14
 */
public interface ApplicationContext {

    Object getBean(String beanId);
}

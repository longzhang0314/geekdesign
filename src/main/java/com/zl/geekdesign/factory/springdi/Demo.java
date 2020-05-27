package com.zl.geekdesign.factory.sprintdi;

/**
 * Create by zhanglong on 2020/5/27
 */
public class Demo {

    public static void main(String[] args) {
        // 解析配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        RateLimiter rateLimiter = (RateLimiter) context.getBean("rateLimiter");
        rateLimiter.test();
    }
}

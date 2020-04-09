package com.zl.geekdesign.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Create by zhanglong on 2020/4/8
 */
@Configuration
@MapperScan("com.zl.geekdesign.demo.mapper")
public class MybatisConfig {
}

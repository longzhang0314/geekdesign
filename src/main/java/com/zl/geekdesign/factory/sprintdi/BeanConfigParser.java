package com.zl.geekdesign.factory.sprintdi;

import java.io.InputStream;
import java.util.List;

/**
 * Create by zhanglong on 2020/4/14
 */
public interface BeanConfigParser {

    List<BeanDefinition> parse(InputStream in);
    List<BeanDefinition> parse(String configContent);
}

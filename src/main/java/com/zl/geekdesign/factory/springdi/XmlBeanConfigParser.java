package com.zl.geekdesign.factory.springdi;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Create by zhanglong on 2020/4/14
 */
public class XmlBeanConfigParser implements BeanConfigParser {
    @Override
    public List<BeanDefinition> parse(InputStream in) {
        String content = null;
        // TODO:...
        return parse(content);
    }

    @Override
    public List<BeanDefinition> parse(String configContent) {
        List<BeanDefinition> beanDefinitions = new ArrayList<>();
        // TODO:...

        return beanDefinitions;
    }
}

package com.zl.geekdesign.factory.springdi;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Create by zhanglong on 2020/4/14
 */
public class ClassPathXmlApplicationContext implements ApplicationContext {

    private BeanFactory beanFactory;
    private BeanConfigParser beanConfigParser;

    public ClassPathXmlApplicationContext(String configLocation) {
        beanFactory = new BeanFactory();
        beanConfigParser = new XmlBeanConfigParser();
        loadBeanDefinitions(configLocation);
    }

    private void loadBeanDefinitions(String configLocation) {
        InputStream in = null;
        try {
            in = this.getClass().getResourceAsStream("/" + configLocation);
            if (in == null) {
                throw new RuntimeException("Can not find config file: " + configLocation);
            }
            List<BeanDefinition> beanDefinitions = beanConfigParser.parse(in);
            beanFactory.addBeanDefinitions(beanDefinitions);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    // ...

                }
            }
        }
    }


    @Override
    public Object getBean(String beanId) {
        return beanFactory.getBean(beanId);
    }
}

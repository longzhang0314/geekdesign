package com.zl.geekdesign.build;

/**
 * Create by zhanglong on 2020/4/14
 */
public class Test {

    public static void main(String[] args) {
        ResourcePoolConfig resourcePoolConfig = new ResourcePoolConfig.Builder()
                .setName("asda")
                .setMaxTotal(12)
                .setMaxIdle(2)
                .setMinIdle(333)
                .build();
    }
}

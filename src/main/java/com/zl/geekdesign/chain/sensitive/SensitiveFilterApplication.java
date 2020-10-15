package com.zl.geekdesign.chain.sensitive;

/**
 * @author liusha
 * @date 2020/10/15
 */
public class SensitiveFilterApplication {

    public static void main(String[] args) {
        String text = "abc";
        SensitiveWordFilterChain chain = new SensitiveWordFilterChain();
        chain.addFilter(new SexySensitiveWordFilter());
        boolean filter = chain.filter(text);
        if (filter) {
            System.out.println("不是敏感词");
        } else {
            System.out.println("敏感词");
        }
    }
}

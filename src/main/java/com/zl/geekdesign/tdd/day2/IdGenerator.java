package com.zl.geekdesign.tdd.day2;

import java.util.UUID;

/**
 * Create by zhanglong on 2020/3/24
 */
public class IdGenerator {

    public static String generateId() {
        return UUID.randomUUID().toString();
    }
}

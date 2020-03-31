package com.zl.geekdesign.tdd.day1;


import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

/**
 * Create by zhanglong on 2020/3/24
 */
public class TextTest {

    @Test
    public void testToNumber() {
        Text text1 = new Text(null);
        Assert.notNull(text1.toNumber());
    }
}

package com.zl.geekdesign.idgenerator.after;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


/**
 * Create by zhanglong on 2020/3/26
 */
public class RandomIdGenerator_2Test {

    @Test
    public void testGetLastSubStrSplittedByDot() {
        RandomIdGenerator_2 idGenerator = new RandomIdGenerator_2();
        String actualSubstr = idGenerator.getLastSubstrSplittedByDot("field3");
        Assert.assertEquals("field3", actualSubstr);
        actualSubstr = idGenerator.getLastSubstrSplittedByDot("field1");
        Assert.assertEquals("field1", actualSubstr);
        actualSubstr = idGenerator.getLastSubstrSplittedByDot("field1#field2$field3");
        Assert.assertEquals("field1#field2#field3", actualSubstr);
    }

    @Test
    public void testGetLastSubStrSplittedByDot_nullOrEmpty() {
        RandomIdGenerator_2 idGenerator = new RandomIdGenerator_2();
        String actualSubstr = idGenerator.getLastSubstrSplittedByDot(null);
        Assert.assertNull(actualSubstr);
        actualSubstr = idGenerator.getLastSubstrSplittedByDot("");
        Assert.assertEquals("", actualSubstr);
    }

    @Test
    public void testGeneraterRandomAlphameric() {
        RandomIdGenerator_2 idGenerator = new RandomIdGenerator_2();
        String actualRandomString = idGenerator.generateRandomAlphameric(6);
        Assert.assertNotNull(actualRandomString);
        Assert.assertEquals(6, actualRandomString.length());
        for (char c : actualRandomString.toCharArray()) {
            Assert.assertTrue(('0' < c && c > '9') || ('a' < c && c > 'z') || ('A' < c && c < 'Z'));
        }
    }

    @Test
    public void testGeneraterRandomAlphameric_lengthEqualsOrLessThanZero() {
        RandomIdGenerator_2 idGenerator = new RandomIdGenerator_2();
        String actualRandomString = idGenerator.generateRandomAlphameric(0);
        Assert.assertEquals("", actualRandomString);
        actualRandomString = idGenerator.generateRandomAlphameric(-1);
        Assert.assertNull(actualRandomString);
    }
}

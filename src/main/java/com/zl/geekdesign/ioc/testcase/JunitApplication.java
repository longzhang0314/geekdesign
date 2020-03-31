package com.zl.geekdesign.ioc.testcase;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by zhanglong on 2020/3/17
 */
public class JunitApplication {

    private static final List<TestCase> testCases = new ArrayList<>();

    public static void register(TestCase testCase) {
        testCases.add(testCase);
    }

    static {
        register(new UserServiceTest1());
    }

    public static void main(String[] args) {
        for (TestCase testCase : testCases) {
            testCase.run();
        }
    }
}

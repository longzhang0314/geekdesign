package com.zl.geekdesign.ioc.testcase;

/**
 * Create by zhanglong on 2020/3/17
 */
public class UserServieceTest {

    public static boolean doTest() {
        return true;
    }

    public static void main(String[] args) {
        //程序员控制流程
        if (doTest()) {
            System.out.println("Test sucessed");
        } else {
            System.out.println("Test failed");
        }
    }
}

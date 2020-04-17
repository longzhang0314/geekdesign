package com.zl.geekdesign.clone;

import java.util.HashMap;

/**
 * Create by zhanglong on 2020/4/17
 */
public class Demo1 {
    private HashMap<String, Search> currentKeyWords = new HashMap<>();
    private long lastUpdateTime = -1;

    public void refresh() {
        HashMap<String, Search> newKeyWords = (HashMap<String, Search>) currentKeyWords.clone();

    }
}

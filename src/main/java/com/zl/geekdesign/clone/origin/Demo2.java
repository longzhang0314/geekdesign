package com.zl.geekdesign.clone.origin;

import com.zl.geekdesign.clone.SearchWord;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 原版新需求
 * Create by zhanglong on 2020/4/17
 */
public class Demo2 {

    private HashMap<String, SearchWord> currentKeyWords = new HashMap<>();
    private long lastUpdateTime = -1;

    public void refresh() {
        HashMap<String, SearchWord> newKeyWords = new LinkedHashMap<>();

        List<SearchWord> toBeUpdatedSearchWords = getSearchWords(lastUpdateTime);
        for (SearchWord searchWord : toBeUpdatedSearchWords) {
            newKeyWords.put(searchWord.getKeyWord(), searchWord);
        }
        currentKeyWords = newKeyWords;
    }

    private List<SearchWord> getSearchWords(long lastUpdateTime) {
        //TODO 从数据库中取出更新时间>lastUpdateTime的数据

        return null;
    }
}

package com.zl.geekdesign.clone.origin;

import com.zl.geekdesign.clone.SearchWord;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 原版
 * Create by zhanglong on 2020/4/17
 */
public class Demo1 {
    private ConcurrentHashMap<String, SearchWord> currentKeyWords = new ConcurrentHashMap<>();
    private long lastUpdateTime = -1;

    // 更新为最新数据
    public void refresh() {
        List<SearchWord> toBeUpdateSearchWords = getSearchWords(lastUpdateTime);
        long maxNewUpdatedTime = lastUpdateTime;
        for (SearchWord searchWord : toBeUpdateSearchWords) {
            if (searchWord.getLastUpdateTime() > maxNewUpdatedTime) {
                maxNewUpdatedTime = searchWord.getLastUpdateTime();
            }
            if (currentKeyWords.containsKey(searchWord.getKeyWord())) {
                currentKeyWords.replace(searchWord.getKeyWord(), searchWord);
            } else {
                currentKeyWords.put(searchWord.getKeyWord(), searchWord);
            }
        }

        lastUpdateTime = maxNewUpdatedTime;
    }

    private List<SearchWord> getSearchWords(long lastUpdateTime) {
        //TODO 从数据库中取出更新时间>lastUpdateTime的数据

        return null;
    }
}

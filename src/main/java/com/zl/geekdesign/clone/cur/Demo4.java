package com.zl.geekdesign.clone.cur;

import com.zl.geekdesign.clone.SearchWord;

import java.util.HashMap;
import java.util.List;

/**
 * 原型 - 深拷贝1 ：递归
 * Create by zhanglong on 2020/6/5
 */
public class Demo4 {

    private HashMap<String, SearchWord> currentKeyWords = new HashMap<>();
    private long lastUpdateTime = -1;

    public void refresh() {
        // 拷贝已有对象的数据，更新少量差值
        // Deep copy
        HashMap<String, SearchWord> newKeywords = new HashMap<>();
        for (HashMap.Entry<String, SearchWord> e : currentKeyWords.entrySet()) {
            SearchWord searchWord = e.getValue();
            SearchWord newSearchWord = new SearchWord(searchWord.getKeyWord(), searchWord.getLastUpdateTime(),
                    searchWord.getCount());
            newKeywords.put(e.getKey(), newSearchWord);
        }

        List<SearchWord> toBeUpdatedSearchWords = getSearchWords(lastUpdateTime);
        long maxLastUpdateTime = lastUpdateTime;
        for (SearchWord searchWord : toBeUpdatedSearchWords) {
            if (searchWord.getLastUpdateTime() > maxLastUpdateTime) {
                maxLastUpdateTime = lastUpdateTime;
            }
            if (newKeywords.containsKey(searchWord.getKeyWord())) {
                SearchWord oldSearchWord = newKeywords.get(searchWord.getKeyWord());
                oldSearchWord.setCount(searchWord.getCount());
                oldSearchWord.setLastUpdateTime(searchWord.getLastUpdateTime());
            } else {
                newKeywords.put(searchWord.getKeyWord(), searchWord);
            }
        }

        lastUpdateTime = maxLastUpdateTime;
        currentKeyWords = newKeywords;
    }

    private List<SearchWord> getSearchWords(long lastUpdateTime) {
        // TODO: 从数据库中取出更新时间>lastUpdateTime的数据
        return null;
    }
}

package com.zl.geekdesign.clone.cur;

import com.zl.geekdesign.clone.SearchWord;

import java.io.*;
import java.util.HashMap;
import java.util.List;

/**
 * 原型
 * Create by zhanglong on 2020/6/5
 */
public class Demo6 {
    private HashMap<String, SearchWord> currentKeyWords = new HashMap<>();
    private long lastUpdateTime = -1;

    public void refresh() throws IOException, ClassNotFoundException {
        // 拷贝已有对象的数据，更新少量差值
        // 浅拷贝 + 只对更新的值做深拷贝
        HashMap<String, SearchWord> newKeywords = (HashMap<String, SearchWord>) currentKeyWords.clone();

        List<SearchWord> toBeUpdatedSearchWords = getSearchWords(lastUpdateTime);
        long maxLastUpdateTime = lastUpdateTime;
        for (SearchWord searchWord : toBeUpdatedSearchWords) {
            if (searchWord.getLastUpdateTime() > maxLastUpdateTime) {
                maxLastUpdateTime = lastUpdateTime;
            }
            if (newKeywords.containsKey(searchWord.getKeyWord())) {
                newKeywords.remove(searchWord.getKeyWord());
            }
            newKeywords.put(searchWord.getKeyWord(), searchWord);
        }

        lastUpdateTime = maxLastUpdateTime;
        currentKeyWords = newKeywords;
    }

    private <T> T deepCopy(T t) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(t);

        ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
        ObjectInputStream oi = new ObjectInputStream(bi);
        return (T) oi.readObject();
    }

    private List<SearchWord> getSearchWords(long lastUpdateTime) {
        // TODO: 从数据库中取出更新时间>lastUpdateTime的数据
        return null;
    }

}

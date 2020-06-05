package com.zl.geekdesign.clone;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * Create by zhanglong on 2020/4/17
 */
@Data
@ToString
public class SearchWord implements Serializable {
    private String keyWord;
    private long lastUpdateTime;
    private int count;


    public SearchWord(String keyWord, long lastUpdateTime, int count) {
        this.keyWord = keyWord;
        this.lastUpdateTime = lastUpdateTime;
        this.count = count;
    }

}

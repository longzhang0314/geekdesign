package com.zl.geekdesign.chain.sensitive;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liusha
 * @date 2020/10/15
 */
public class SensitiveWordFilterChain {

    private List<SensitiveWordFilter> chains = new ArrayList<>();

    public void addFilter(SensitiveWordFilter sensitiveWordFilter) {
        chains.add(sensitiveWordFilter);
    }

    public boolean filter(String text) {
        for (SensitiveWordFilter wordFilter : chains) {
            if (!wordFilter.filter(text)) {
                return false;
            }
        }
        return true;
    }
}

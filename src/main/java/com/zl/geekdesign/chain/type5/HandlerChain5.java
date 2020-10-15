package com.zl.geekdesign.chain.type5;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liusha
 * @date 2020/10/15
 */
public class HandlerChain5 {
    List<IHandler5> chains = new ArrayList<>();

    public void addChain(IHandler5 iHandler5) {
        chains.add(iHandler5);
    }

    public void handler() {
        for (IHandler5 iHandler5 : chains) {
            iHandler5.handler();
        }
    }
}

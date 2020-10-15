package com.zl.geekdesign.chain.type3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liusha
 * @date 2020/10/15
 */
public class HandlerChain3 {
    private List<IHandler3> handlers = new ArrayList<>();

    public void addHandler(IHandler3 iHandler3) {
        handlers.add(iHandler3);
    }

    public void handler() {
        for (IHandler3 iHandler3 : handlers) {
            boolean handler = iHandler3.handler();
            if (!handler) {
                break;
            }
        }
    }
}

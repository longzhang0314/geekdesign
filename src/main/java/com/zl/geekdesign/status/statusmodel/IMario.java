package com.zl.geekdesign.status.statusmodel;

import com.zl.geekdesign.status.State;

/**
 * @author liusha
 * @date 2020/10/21
 */
public interface IMario {
    State getName();

    void obtainMushRoom();

    void obtainCape();

    void obtainFireFlow();

    void meetMonster();
}

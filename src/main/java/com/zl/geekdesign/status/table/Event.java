package com.zl.geekdesign.status.table;

/**
 * 事件
 *
 * @author liusha
 * @date 2020/10/21
 */
public enum Event {

    GOT_MUSHROOM(0),
    GOT_CAPE(1),
    GOT_FIRE(2),
    MET_MONSTER(3),
    ;

    private int value;

    private Event(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
package com.zl.geekdesign.status;

/**
 * 状态
 *
 * @author liusha
 * @date 2020/10/21
 */
public enum State {

    SMALL(0),
    SUPER(1),
    FIRE(2),
    CAPE(3),
    ;

    private int value;

    private State(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}

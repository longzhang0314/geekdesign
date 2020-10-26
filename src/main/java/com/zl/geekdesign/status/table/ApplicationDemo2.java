package com.zl.geekdesign.status.table;

import com.zl.geekdesign.status.State;

/**
 * @author liusha
 * @date 2020/10/21
 */
public class ApplicationDemo2 {

    public static void main(String[] args) {
        MarioStateMachine2 mario = new MarioStateMachine2();
        mario.obtainMushRoom();
        int score = mario.getScore();
        State state = mario.getCurrentState();
        System.out.println("mario score：" + score + "; state: " + state);
    }
}

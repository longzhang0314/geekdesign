package com.zl.geekdesign.status.simple;

import com.zl.geekdesign.status.State;

/**
 * @author liusha
 * @date 2020/10/21
 */
public class ApplicationDemo {

    public static void main(String[] args) {
        MarioStateMachine mario = new MarioStateMachine();
        mario.obtainMushRoom();
        int score = mario.getScore();
        State state = mario.getCurrentState();
        System.out.println("mario score：" + score + "; state: " + state);
    }
}

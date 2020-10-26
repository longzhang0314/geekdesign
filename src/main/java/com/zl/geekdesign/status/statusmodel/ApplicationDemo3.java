package com.zl.geekdesign.status.statusmodel;

import com.zl.geekdesign.status.State;
import com.zl.geekdesign.status.simple.MarioStateMachine;

/**
 * @author liusha
 * @date 2020/10/21
 */
public class ApplicationDemo3 {

    public static void main(String[] args) {
        MarioStateMachine3 mario = new MarioStateMachine3();
        mario.obtainMushRoom();
        int score = mario.getScore();
        State state = mario.getCurrentState().getName();
        System.out.println("mario score：" + score + "; state: " + state);
    }
}

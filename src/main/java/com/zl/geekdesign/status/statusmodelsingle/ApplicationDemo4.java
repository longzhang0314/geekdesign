package com.zl.geekdesign.status.statusmodelsingle;

import com.zl.geekdesign.status.State;
import com.zl.geekdesign.status.statusmodel.MarioStateMachine3;

/**
 * @author liusha
 * @date 2020/10/21
 */
public class ApplicationDemo4 {

    public static void main(String[] args) {
        MarioStateMachine4 mario = new MarioStateMachine4();
        mario.obtainMushRoom();
        int score = mario.getScore();
        State state = mario.getCurrentState().getName();
        System.out.println("mario score：" + score + "; state: " + state);
    }
}

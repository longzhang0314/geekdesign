package com.zl.geekdesign.status.statusmodelsingle;

import com.zl.geekdesign.status.statusmodel.IMario;
import com.zl.geekdesign.status.statusmodel.SmallMario;

/**
 * @author liusha
 * @date 2020/10/21
 */
public class MarioStateMachine4 {
    private int score;
    private IMario2 currentState;

    public MarioStateMachine4() {
        this.score = 0;
        this.currentState = SmallMario2.getInstance();
    }

    public void obtainMushRoom() {
        this.currentState.obtainMushRoom(this);
    }

    public void obtainCape() {
        this.currentState.obtainCape(this);
    }

    public void obtainFireFlow() {
        this.currentState.obtainFireFlow(this);
    }

    public void meetMonster() {
        this.currentState.meetMonster(this);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public IMario2 getCurrentState() {
        return currentState;
    }

    public void setCurrentState(IMario2 currentState) {
        this.currentState = currentState;
    }
}

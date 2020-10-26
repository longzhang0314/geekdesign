package com.zl.geekdesign.status.statusmodel;

/**
 * @author liusha
 * @date 2020/10/21
 */
public class MarioStateMachine3 {
    private int score;
    private IMario currentState;

    public MarioStateMachine3() {
        this.score = 0;
        this.currentState = new SmallMario(this);
    }

    public void obtainMushRoom() {
        this.currentState.obtainMushRoom();
    }

    public void obtainCape() {
        this.currentState.obtainCape();
    }

    public void obtainFireFlow() {
        this.currentState.obtainFireFlow();
    }

    public void meetMonster() {
        this.currentState.meetMonster();
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public IMario getCurrentState() {
        return currentState;
    }

    public void setCurrentState(IMario currentState) {
        this.currentState = currentState;
    }
}

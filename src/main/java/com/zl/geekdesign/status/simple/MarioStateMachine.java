package com.zl.geekdesign.status.simple;


import com.zl.geekdesign.status.State;

/**
 * 状态机 - 分支逻辑实现
 *
 * @author liusha
 * @date 2020/10/21
 */
public class MarioStateMachine {
    private int score;
    private State currentState;

    public MarioStateMachine() {
        this.score = 0;
        this.currentState = State.SMALL;
    }

    public void obtainMushRoom() {
        if (currentState.equals(State.SMALL)) {
            this.score += 100;
            this.currentState = State.SUPER;
        }
    }

    public void obtainCape() {
        if (currentState.equals(State.SMALL) || currentState.equals(State.SUPER)) {
            this.score += 200;
            this.currentState = State.CAPE;
        }

    }

    public void obtainFireFlower() {
        if (currentState.equals(State.SMALL) || currentState.equals(State.SUPER)) {
            this.score += 300;
            this.currentState = State.FIRE;
        }
    }

    public void meetMonster() {
        if (currentState.equals(State.SUPER)) {
            this.score -= 100;
            this.currentState = State.SMALL;
            return;
        }

        if (currentState.equals(State.CAPE)) {
            this.score -= 200;
            this.currentState = State.SMALL;
            return;
        }

        if (currentState.equals(State.FIRE)) {
            this.score -= 300;
            this.currentState = State.SMALL;
            return;
        }
    }

    public int getScore() {
        return this.score;
    }

    public State getCurrentState() {
        return this.currentState;
    }

}

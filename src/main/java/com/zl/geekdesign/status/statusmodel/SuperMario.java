package com.zl.geekdesign.status.statusmodel;

import com.zl.geekdesign.status.State;

/**
 * @author liusha
 * @date 2020/10/21
 */
public class SuperMario implements IMario {
    private MarioStateMachine3 stateMachine;

    public SuperMario(MarioStateMachine3 stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Override
    public State getName() {
        return State.SUPER;
    }

    @Override
    public void obtainMushRoom() {
        stateMachine.setCurrentState(this);
        stateMachine.setScore(stateMachine.getScore() + 100);
    }

    @Override
    public void obtainCape() {
        // ...
    }

    @Override
    public void obtainFireFlow() {

    }

    @Override
    public void meetMonster() {

    }
}

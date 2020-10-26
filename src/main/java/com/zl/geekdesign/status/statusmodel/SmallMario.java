package com.zl.geekdesign.status.statusmodel;

import com.zl.geekdesign.status.State;

/**
 * @author liusha
 * @date 2020/10/21
 */
public class SmallMario implements IMario {
    private MarioStateMachine3 stateMachine;

    public SmallMario(MarioStateMachine3 stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Override
    public State getName() {
        return State.SMALL;
    }

    @Override
    public void obtainMushRoom() {
        stateMachine.setCurrentState(new SuperMario(stateMachine));
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

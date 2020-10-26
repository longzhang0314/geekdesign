package com.zl.geekdesign.status.statusmodelsingle;

import com.zl.geekdesign.status.State;
import com.zl.geekdesign.status.statusmodel.SuperMario;

/**
 * @author liusha
 * @date 2020/10/26
 */
public class SuperMario2 implements IMario2 {
    @Override
    public State getName() {
        return State.SUPER;
    }

    private SuperMario2() {}

    private static final SuperMario2 instance = new SuperMario2();

    public static SuperMario2 getInstance() {
        return instance;
    }

    @Override
    public void obtainMushRoom(MarioStateMachine4 marioStateMachine4) {
        //...
    }

    @Override
    public void obtainCape(MarioStateMachine4 marioStateMachine4) {

    }

    @Override
    public void obtainFireFlow(MarioStateMachine4 marioStateMachine4) {

    }

    @Override
    public void meetMonster(MarioStateMachine4 marioStateMachine4) {

    }
}

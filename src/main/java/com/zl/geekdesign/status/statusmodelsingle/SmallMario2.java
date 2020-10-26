package com.zl.geekdesign.status.statusmodelsingle;

import com.zl.geekdesign.status.State;
import com.zl.geekdesign.status.statusmodel.IMario;
import com.zl.geekdesign.status.statusmodel.SmallMario;

/**
 * @author liusha
 * @date 2020/10/26
 */
public class SmallMario2 implements IMario2 {

    private  SmallMario2() {}

    private static final SmallMario2 instance = new SmallMario2();

    public static SmallMario2 getInstance() {
        return instance;
    }

    @Override
    public State getName() {
        return State.SMALL;
    }

    @Override
    public void obtainMushRoom(MarioStateMachine4 marioStateMachine4) {
        marioStateMachine4.setCurrentState(SuperMario2.getInstance());
        marioStateMachine4.setScore(marioStateMachine4.getScore() + 100);
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

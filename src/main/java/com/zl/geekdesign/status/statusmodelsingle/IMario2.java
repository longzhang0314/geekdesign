package com.zl.geekdesign.status.statusmodelsingle;

import com.zl.geekdesign.status.State;

/**
 * @author liusha
 * @date 2020/10/26
 */
public interface IMario2 {

    State getName();

    void obtainMushRoom(MarioStateMachine4 marioStateMachine4);

    void obtainCape(MarioStateMachine4 marioStateMachine4);

    void obtainFireFlow(MarioStateMachine4 marioStateMachine4);

    void meetMonster(MarioStateMachine4 marioStateMachine4);

}

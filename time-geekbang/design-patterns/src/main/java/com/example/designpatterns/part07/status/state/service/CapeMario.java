package com.example.designpatterns.part07.status.state.service;

import com.example.designpatterns.part07.status.State;
import com.example.designpatterns.part07.status.state.MarioStateMachine;

/**
 上面的代码还可以继续优化，我们可以将状态类设计成单例，毕竟状态类中不包含任何成员变量。
 但是，当将状态类设计成单例之后，我们就无法通过构造函数来传递 MarioStateMachine 了，
 而状态类又要依赖 MarioStateMachine，那该如何解决这个问题呢？
 **/
public class CapeMario implements IMario {
    public CapeMario(MarioStateMachine stateMachine) {
    }

    @Override
    public State getName() {
        return null;
    }

    @Override
    public void obtainMushRoom() {

    }

    @Override
    public void obtainCape() {

    }

    @Override
    public void obtainFireFlower() {

    }

    @Override
    public void meetMonster() {

    }
}

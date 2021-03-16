package com.example.designpatterns.part07.status.state.service;

import com.example.designpatterns.part07.status.State;
import com.example.designpatterns.part07.status.state.MarioStateMachine;

/**
 * Description:
 * date: 2021/3/16 11:50
 *
 * @author dqk
 */
public class FireMario implements IMario {
    public FireMario(MarioStateMachine stateMachine) {
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

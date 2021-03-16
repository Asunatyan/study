package com.example.designpatterns.part07.status;

/**
 * Description:
 * date: 2021/3/16 11:34
 *
 * @author dqk
 */
public enum State {
    SMALL(0),SUPER(1),CAPE(2),FIRE(3);//value代表维度

    State(int value) {
        this.value = value;
    }

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

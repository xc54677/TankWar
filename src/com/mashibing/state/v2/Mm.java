package com.mashibing.state.v2;

public class Mm {
    String name;
    MMState state;

    private void smile(){
        state.smile();
    }

    public void cry(){
        state.cry();
    }

    public void say() {
        state.say();
    }
}

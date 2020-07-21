package com.mashibing.observer;

public class Dog implements Observer{

    private void bar(){
        System.out.println("wangwang..........");
    }

    @Override
    public void action(WakeUpEvent event) {
        bar();
    }
}

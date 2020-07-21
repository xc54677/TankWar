package com.mashibing.observer;

public class Mom implements Observer{

    private void hug(){
        System.out.println("Hugging..........");
    }

    @Override
    public void action(WakeUpEvent event) {
        hug();
    }
}

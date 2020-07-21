package com.mashibing.observer;

public class Dad implements Observer{

    private void feed(){
        System.out.println("Feeding..........");
    }

    @Override
    public void action(WakeUpEvent event) {
        feed();
    }
}

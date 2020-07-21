package com.mashibing.observer;

import java.util.ArrayList;

public class Baby {
    private boolean cry = false;
    private ArrayList<Observer> observers = new ArrayList<>();
    Dad dad = new Dad();
    Mom mom = new Mom();
    Dog dog = new Dog();

    public Baby() {
        observers.add(dad);
        observers.add(mom);
        observers.add(dog);
        observers.add((event)->{
            System.out.println("PP...");
        });
    }

    public boolean isCry(){
        return cry;
    }

    public void wakeup(){
        cry = true;

        WakeUpEvent event = new WakeUpEvent(System.currentTimeMillis(), "bed", this);
        observers.forEach(o -> {
            o.action(event);
        });
    }
}

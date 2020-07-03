package com.mashibing.factoryMethod;

public class CarFactory {
    public Moveable create(){
        return new Car();
    }
}

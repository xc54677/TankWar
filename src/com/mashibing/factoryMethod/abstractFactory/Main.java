package com.mashibing.factoryMethod.abstractFactory;

import com.mashibing.factoryMethod.CarFactory;
import com.mashibing.factoryMethod.Moveable;

public class Main {
    public static void main(String[] args) {
        AbstractFactory f = new MordenFactory();

        Vehicle car = f.createVehicle();
        car.go();
        Weapon ak47 = f.createWeapon();
        ak47.shoot();
        Food bread = f.createFood();
        bread.printName();
    }
}

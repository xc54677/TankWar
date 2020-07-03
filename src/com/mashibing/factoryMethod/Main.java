package com.mashibing.factoryMethod;

public class Main {
    public static void main(String[] args) {
        Moveable c = new CarFactory().create();
        c.go();
    }
}

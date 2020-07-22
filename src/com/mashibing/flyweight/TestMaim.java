package com.mashibing.flyweight;

public class TestMaim {
    public static void main(String[] args) {
        BulletPool bp = new BulletPool();

        for (int i = 0; i < 10; i++){
            Bullet b = bp.getBullet();
            System.out.println(b);
        }
    }
}

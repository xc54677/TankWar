package com.mashibing.flyweight;

import java.util.ArrayList;

public class BulletPool {
    ArrayList<Bullet> bullets = new ArrayList<>();

    {
        for(int i = 0; i < 5; i++){
            bullets.add(new Bullet());
        }
    }

    public Bullet getBullet(){
        for (int i = 0; i < bullets.size(); i++){
            Bullet b = bullets.get(i);
            if (!b.living){
                return b;
            }
        }
        return new Bullet();
    }
}

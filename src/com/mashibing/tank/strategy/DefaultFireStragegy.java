package com.mashibing.tank.strategy;

import com.mashibing.tank.Bullet;
import com.mashibing.tank.GameModel;
import com.mashibing.tank.Tank;
import com.mashibing.tank.decorator.RectDecorator;
import com.mashibing.tank.decorator.TailDecorator;

/**
 * 默认开火策略，一次只打出一颗子弹
 */
public class DefaultFireStragegy implements FireStrategy {
    @Override
    public void fire(Tank t) {
        int bX = t.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = t.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        //bug --> Bullet里又把自己往gamemodel里添加了一次
        GameModel.getInstance().add(new RectDecorator(new TailDecorator(new Bullet(bX, bY, t.dir, t.group))));

//        if (t.group == Group.GOOD){ new Thread(() -> new Audio("audio/tank_fire.wav")); }
    }
}

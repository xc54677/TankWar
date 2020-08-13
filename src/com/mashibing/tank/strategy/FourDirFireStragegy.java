package com.mashibing.tank.strategy;

import com.mashibing.tank.Bullet;
import com.mashibing.tank.Dir;
import com.mashibing.tank.Tank;
import com.mashibing.tank.strategy.FireStrategy;

import java.io.Serializable;

/**
 * 特殊开火策略：四个方向都打出子弹
 */
public class FourDirFireStragegy implements FireStrategy, Serializable {
    @Override
    public void fire(Tank t) {
        int bX = t.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = t.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;

        Dir[] dirs = Dir.values();
        for (Dir dir : dirs) {
            new Bullet(bX, bY, dir, t.group);
        }

    }
}

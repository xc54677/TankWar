package com.mashibing.tank;

import java.awt.*;
import java.util.ArrayList;

public class GameModel {
    Tank myTank = new Tank(200, 400, Dir.DOWN, Group.GOOD,this);
    ArrayList<Bullet> bullets = new ArrayList<>();
    ArrayList<Tank> tanks = new ArrayList<>();
    ArrayList<Explode> explodes = new ArrayList<>();

    public GameModel() {
        int initTankCount = Integer.parseInt((String) PropertyMgr.getProps().get("initTankCount"));

        for (int i = 0; i < initTankCount; i++){
            tanks.add(new Tank(50+i*80, 200, Dir.DOWN, Group.BAD, this));
        }
    }

    public void paint(Graphics g){
        Color c = g.getColor();
        g.setColor(Color.black);
        g.drawString("子弹的数量：" + bullets.size(), 10, 60);
        g.drawString("敌方坦克的数量：" + tanks.size(), 10, 80);
        g.drawString("爆炸的数量：" + explodes.size(), 10, 100);
        g.setColor(c);

        myTank.paint(g);
        for (int i = 0; i < bullets.size(); i++){
            bullets.get(i).paint(g);
        }

        //画敌方坦克
        for (int i = 0; i < tanks.size(); i++){
            tanks.get(i).paint(g);
        }

        //画出爆炸图片
        for (int i = 0; i < explodes.size(); i++){
            explodes.get(i).paint(g);
        }

        //子弹和坦克的碰撞检测
        for (int i = 0; i < bullets.size(); i++){
            for (int j = 0; j < tanks.size(); j++){
                bullets.get(i).collideWith(tanks.get(j));
            }
        }
    }

    public Tank getMyTank() {
        return myTank;
    }
}

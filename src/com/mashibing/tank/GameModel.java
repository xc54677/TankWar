package com.mashibing.tank;

import com.mashibing.tank.cor.BulletTankCollider;
import com.mashibing.tank.cor.Collider;

import java.awt.*;
import java.util.ArrayList;

public class GameModel {
    Tank myTank = new Tank(200, 400, Dir.DOWN, Group.GOOD,this);

//    ArrayList<Bullet> bullets = new ArrayList<>();
//    ArrayList<Tank> tanks = new ArrayList<>();
//    ArrayList<Explode> explodes = new ArrayList<>();

    Collider collider = new BulletTankCollider();

    private ArrayList<GameObject> objects = new ArrayList<>();

    public GameModel() {
        int initTankCount = Integer.parseInt((String) PropertyMgr.getProps().get("initTankCount"));

        for (int i = 0; i < initTankCount; i++){
            add(new Tank(50+i*80, 200, Dir.DOWN, Group.BAD, this));
        }
    }

    public void add(GameObject go){
        this.objects.add(go);
    }

    public void remove(GameObject go){
        this.objects.remove(go);
    }

    public void paint(Graphics g){
        Color c = g.getColor();
        g.setColor(Color.black);
//        g.drawString("子弹的数量：" + bullets.size(), 10, 60);
//        g.drawString("敌方坦克的数量：" + tanks.size(), 10, 80);
//        g.drawString("爆炸的数量：" + explodes.size(), 10, 100);
        g.setColor(c);

        myTank.paint(g);
        for (int i = 0; i < objects.size(); i++){
            objects.get(i).paint(g);
        }

        for (int i = 0; i < objects.size(); i++){
            for (int j = i+1; j < objects.size(); j++){
                GameObject o1 = objects.get(i);
                GameObject o2 = objects.get(j);
                collider.collide(o1,o2);
            }
        }

        //子弹和坦克的碰撞检测
//        for (int i = 0; i < bullets.size(); i++){
//            for (int j = 0; j < tanks.size(); j++){
//                bullets.get(i).collideWith(tanks.get(j));
//            }
//        }
    }

    public Tank getMyTank() {
        return myTank;
    }
}

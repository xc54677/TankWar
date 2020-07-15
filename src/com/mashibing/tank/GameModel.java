package com.mashibing.tank;

import com.mashibing.tank.cor.BulletTankCollider;
import com.mashibing.tank.cor.Collider;
import com.mashibing.tank.cor.ColliderChain;
import com.mashibing.tank.cor.TankTankCollider;

import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class GameModel {
    private static final GameModel INSTANCE = new GameModel();

    static {
        INSTANCE.init();
    }

    Tank myTank;

//    ArrayList<Bullet> bullets = new ArrayList<>();
//    ArrayList<Tank> tanks = new ArrayList<>();
//    ArrayList<Explode> explodes = new ArrayList<>();

    ColliderChain chain = new ColliderChain();

    private ArrayList<GameObject> objects = new ArrayList<>();

    private GameModel() {

    }

    private void init(){
        myTank = new Tank(200, 400, Dir.DOWN, Group.GOOD);

        int initTankCount = Integer.parseInt((String) PropertyMgr.getProps().get("initTankCount"));

        for (int i = 0; i < initTankCount; i++){
            new Tank(50+i*80, 200, Dir.DOWN, Group.BAD);
        }

        //初始化墙
        add(new Wall(150, 150, 200, 50));
        add(new Wall(550, 150, 200, 50));
        add(new Wall(300, 300, 50, 200));
        add(new Wall(550, 300, 50, 200));
    }

    public static GameModel getInstance(){
        return INSTANCE;
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
                chain.collide(o1, o2);
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

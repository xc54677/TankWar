package com.mashibing.tank;

import com.mashibing.tank.strategy.DefaultFireStragegy;
import com.mashibing.tank.strategy.FireStrategy;
import com.mashibing.tank.strategy.FourDirFireStragegy;

import java.awt.*;
import java.util.Random;

public class Tank extends GameObject{

    public int x, y;
    int oldX, oldY;
    public Dir dir = Dir.DOWN;
    private static final int SPEED = 5;

    public static final int WIDTH = ResourceMgr.goodTankU.getWidth();
    public static final int HEIGHT = ResourceMgr.goodTankU.getHeight();

    private boolean moving = true;
    private boolean living = true;

    private Random random = new Random();

    public Group group = Group.BAD;
    public Rectangle rect = new Rectangle();

    FireStrategy fireStrategy;

    public Tank(int x, int y, Dir dir, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;

        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;

        if (group == Group.GOOD){
            String goodFSName = (String) PropertyMgr.get("goodFS");
            try {
                fireStrategy = (FourDirFireStragegy)Class.forName(goodFSName).getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
//            fireStrategy = new FourDirFireStragegy();
        }else {
            String badFSName = (String) PropertyMgr.get("badFS");
            try {
                fireStrategy = (DefaultFireStragegy)Class.forName(badFSName).getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
//            fireStrategy = new DefaultFireStragegy();
        }
        if (this.group == Group.BAD){
            GameModel.getInstance().add(this);
        }
    }

    @Override
    public void paint(Graphics g) {
        if(!living) {
            GameModel.getInstance().remove(this);
        }
        switch (dir){
            case LEFT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankL : ResourceMgr.badTankL, x, y, null);
                break;
            case UP:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankU : ResourceMgr.badTankU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankR : ResourceMgr.badTankR, x, y, null);
                break;
            case DOWN:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankD : ResourceMgr.badTankD, x, y, null);
                break;
            default:
                break;
        }


        move();
    }

    private void move() {
        //记录移动之前都位置
        oldX = x;
        oldY = y;
        if (!moving) {return;}
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                break;
        }

        if (this.group == Group.BAD && random.nextInt(100) > 95) {
            this.fire();
        }
        if (this.group == Group.BAD && random.nextInt(100) > 95){
            randomDir();
        }
        //坦克边界检测
        boundsCheck();

        //update rect value
        rect.x = this.x;
        rect.y = this.y;
    }

    private void boundsCheck() {
        if (this.x < 2) { x = 2;}
        if (this.y < 28) {y = 28;}

        if (this.x > TankFrame.GAME_WIDTH - Tank.WIDTH - 2) { x = TankFrame.GAME_WIDTH - Tank.WIDTH - 2;}
        if (this.y > TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2) {y = TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2;}

    }

    private void randomDir() {

        this.dir = Dir.values()[random.nextInt(4)];
    }

    public void stop(){
        moving = false;
    }

    public void fire() {
        fireStrategy.fire(this);
    }

    public void die() {
        this.living = false;
    }

    public void back(){
        x = oldX;
        y = oldY;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Rectangle getRect() {
        return rect;
    }

    public void setRect(Rectangle rect) {
        this.rect = rect;
    }
}

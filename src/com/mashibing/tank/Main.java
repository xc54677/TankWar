package com.mashibing.tank;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        //新建windows窗口
        TankFrame tf = new TankFrame();



        while (true){
            Thread.sleep(50);
            tf.repaint();
        }
    }

}

package com.mashibing.singleton;

/**
 * 懒汉式
 * 达到了按需初始化的目的, 方法上加锁，解决了线程不安全的问题
 * 但是锁加在方法上显的太重了，效率也会下降
 */
public class Mgr04 {
    private static Mgr04 INSTANCE;

    private Mgr04() {}

    public synchronized static Mgr04 getInstance(){
        if (INSTANCE == null){
            INSTANCE = new Mgr04();
        }
        return INSTANCE;
    }
    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args) {
        Mgr04 m1 = Mgr04.getInstance();
        Mgr04 m2 = Mgr04.getInstance();
        System.out.println(m1 == m2);
    }
}

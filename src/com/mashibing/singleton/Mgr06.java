package com.mashibing.singleton;

/**
 * 懒汉式
 * 双重检查，解决了Mgr05中即提高了效率，也解决了线程不安全的问题
 */
public class Mgr06 {
    private static Mgr06 INSTANCE;

    private Mgr06() {}

    public synchronized static Mgr06 getInstance(){
        if (INSTANCE == null){
            //双重检查，解决了Mgr05中即提高了效率，也解决了线程不安全的问题
            synchronized (Mgr06.class){
                if (INSTANCE == null) {
                    INSTANCE = new Mgr06();
                }
            }
        }
        return INSTANCE;
    }
    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args) {
        Mgr06 m1 = Mgr06.getInstance();
        Mgr06 m2 = Mgr06.getInstance();
        System.out.println(m1 == m2);
    }
}

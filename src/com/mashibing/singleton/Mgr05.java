package com.mashibing.singleton;

/**
 * 懒汉式
 * 达到了按需初始化的目的, 方法上加锁，解决了线程不安全的问题
 * 但是锁加在方法上显的太重了，效率也会下降
 */
public class Mgr05 {
    private static Mgr05 INSTANCE;

    private Mgr05() {}

    public synchronized static Mgr05 getInstance(){
        if (INSTANCE == null){
            //妄图通过减小同步块的方式提高效率，但是不可行，线程还是不安全
            synchronized (Mgr05.class){
                INSTANCE = new Mgr05();
            }
        }
        return INSTANCE;
    }
    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args) {
        Mgr05 m1 = Mgr05.getInstance();
        Mgr05 m2 = Mgr05.getInstance();
        System.out.println(m1 == m2);
    }
}

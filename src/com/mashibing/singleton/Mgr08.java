package com.mashibing.singleton;

import com.sun.tools.javadoc.Start;

/**
 * 不仅可以解决线程同步安全问题，还可以防止反序列化
 */
public enum Mgr08 {

    INSTANCE;

    public void m(){}

    public static void main(String[] args) {
        System.out.println(Mgr08.INSTANCE.getClass().getName());
        /*for (int i = 0; i < 100; i++){
            new Thread(() -> {
                System.out.println(Mgr08.INSTANCE.hashCode());
            }).start();
        }*/
    }

}

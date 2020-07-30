package com.mashibing.iterator.v1;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        ArrayList_ list = new ArrayList_();
        for (int i = 0; i < 15; i++){
            list.add(new String("S" + i));
        }
        System.out.println(list.size());
    }
}

class ArrayList_{
    Object[] objects = new Object[10];

    private int index = 0;

    public void add(Object o){
        if (index == objects.length){
            Object[] newObjects = new Object[objects.length*2];
            System.arraycopy(objects, 0, newObjects, 0, objects.length);
            objects = newObjects;
        }
        objects[index]=o;
        index ++;
    }

    public  int size(){
        return index;
    }
}

package com.mashibing.iterator.v4;


public class Main {
    public static void main(String[] args) {
        Collection_ list = new ArrayList_();
        for (int i = 0; i < 15; i++){
            list.add(new String("S" + i));
        }
        System.out.println(list.size());

        Iterator_ it = list.iterator();
        while (it.hasNext()){
            Object o = it.next();
            System.out.println(o);
        }
    }
}

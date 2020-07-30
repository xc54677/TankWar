package com.mashibing.iterator.v5;


public class Main {
    public static void main(String[] args) {
        Collection_<String> list = new ArrayList_<>();
        for (int i = 0; i < 15; i++){
            list.add(new String("S" + i));
        }
        System.out.println(list.size());

        Iterator_<String> it = list.iterator();
        while (it.hasNext()){
            String o = it.next();
            System.out.println(o);
        }
    }
}

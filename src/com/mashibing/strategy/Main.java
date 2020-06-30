package com.mashibing.strategy;

import java.util.Arrays;

/**
 * 策略模式
 */
public class Main {
    public static void main(String[] args) {
//        int[] a = {9,2,3,5,7,1,4};
//        Cat[] a = {new Cat(3,3), new Cat(5,5), new Cat(1,1)};
        Dog[] d = {new Dog(3), new Dog(5), new Dog(1)};
        Sorter<Dog> sorter = new Sorter<>();
        //1.
//        sorter.sort(d, new DogComparator());

        //2.
        sorter.sort(d, (o1, o2) -> {
            if (o1.food < o2.food){
                return -1;
            }else if (o1.food > o2.food){
                return 1;
            }else {
                return 0;
            }
        });

        System.out.println(Arrays.toString(d));
    }
}

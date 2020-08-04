package com.mashibing.builder;

public class MainTest {
    public static void main(String[] args) {
        TerrainBuilder builder = new ComplexTerrainBuilder();
        Terrain t = builder.buildWall().buildFort().buildWall().build();

        Person p = new Person.PersonBuilder()
                .basicInfo(1, "zhangsan", 18)
                .score(20)
                .weight(200).loc("bj", "23")
                .build();
    }
}

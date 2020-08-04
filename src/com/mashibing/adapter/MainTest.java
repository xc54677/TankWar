package com.mashibing.adapter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class MainTest {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("/Users/xiao/IdeaProjects/TankWar/src/com/mashibing/adapter/test");
        InputStreamReader isr = new InputStreamReader(fis);

        BufferedReader br = new BufferedReader(isr);
        String line = br.readLine();
        while (line != null && !line.equals("")){
            System.out.println(line);
        }
        br.close();
    }
}

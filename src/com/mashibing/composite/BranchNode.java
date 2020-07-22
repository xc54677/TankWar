package com.mashibing.composite;

import java.util.ArrayList;

public class BranchNode extends Node{
    ArrayList<Node> nodes = new ArrayList<>();
    String name;

    public BranchNode(String name) {
        this.name = name;
    }

    @Override
    public void p() {
        System.out.println(name);
    }

    public void add(Node n){
        nodes.add(n);
    }
}

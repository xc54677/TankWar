package com.mashibing.state.v1;

public class Mm {
    String name;
    private enum MMState {HAPPY, SAD};

    MMState state = MMState.HAPPY;

    private void smile(){
        switch (state) {
            case HAPPY:
                System.out.println("happy smile");
                break;
            case SAD:
                System.out.println("sad smile");
                break;
            default:
                break;
        }

    }

    public void cry(){}

    public void say() {}
}

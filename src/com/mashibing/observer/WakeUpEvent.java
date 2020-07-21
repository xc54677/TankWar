package com.mashibing.observer;

public class WakeUpEvent extends Event<Baby>{
    long timeStamp;
    String location;
    private Baby source;

    public WakeUpEvent(long timeStamp, String location, Baby source) {
        this.timeStamp = timeStamp;
        this.location = location;
        this.source = source;
    }

    @Override
    public Baby getSource() {
        return source;
    }
}

package com.horoscope.horoscope.entity.event;

public class AddTypeEvent {
    public String name;
    public int type;

    public AddTypeEvent(String name, int type) {
        this.name = name;
        this.type = type;
    }
}

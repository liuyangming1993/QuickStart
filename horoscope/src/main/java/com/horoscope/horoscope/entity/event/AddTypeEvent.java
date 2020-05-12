package com.horoscope.horoscope.entity.event;

/**
 * 选择日记本->1;选择todo列表->2;
 */
public class AddTypeEvent {
    public String name;
    public AddTypeEvent(String name) {
        this.name = name;
    }
}

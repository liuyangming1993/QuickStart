package com.horoscope.horoscope.entity.event;

/**
 * 选择日记本->1;选择todo列表->2;
 */
public class ChooseTypeEvent {
    public static final int TYPE_DIARY = 1;
    public static final int TYPE_TODO_LIST = 2;
    public int type;
    public ChooseTypeEvent(int type) {
        this.type = type;
    }
}

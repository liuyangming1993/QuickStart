package com.horoscope.horoscope.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "diary")
public class DiaryBean {
    @Id
    @NotNull
    private Long id;

    @Generated(hash = 1701109577)
    public DiaryBean(@NotNull Long id) {
        this.id = id;
    }

    @Generated(hash = 1749744078)
    public DiaryBean() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

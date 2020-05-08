package com.horoscope.horoscope.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "todo")
public class TodoBean {
    @Id
    @NotNull
    private Long id;

    @Generated(hash = 170793656)
    public TodoBean(@NotNull Long id) {
        this.id = id;
    }

    @Generated(hash = 1563990781)
    public TodoBean() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

package com.horoscope.horoscope.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "todo_list")
public class TodoListBean {
    @Id
    @NotNull
    private Long id;

    @Generated(hash = 30886535)
    public TodoListBean(@NotNull Long id) {
        this.id = id;
    }

    @Generated(hash = 1494668603)
    public TodoListBean() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

package com.horoscope.horoscope.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "todo_list")
public class TodoListBean {
    @Id(autoincrement = true)
    @NotNull
    private Long id;
    /**
     * 标题
     */
    private String title;
    /**
     * 创建时刻
     */
    private Long createTime;
    /**
     * 创建人
     */
    private Long createUser;
    @Generated(hash = 448245965)
    public TodoListBean(@NotNull Long id, String title, Long createTime,
            Long createUser) {
        this.id = id;
        this.title = title;
        this.createTime = createTime;
        this.createUser = createUser;
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
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Long getCreateTime() {
        return this.createTime;
    }
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
    public Long getCreateUser() {
        return this.createUser;
    }
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }
}

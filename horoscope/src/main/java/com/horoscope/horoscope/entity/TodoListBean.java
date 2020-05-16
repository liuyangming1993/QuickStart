package com.horoscope.horoscope.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;

@Entity(nameInDb = "todo_list")
public class TodoListBean {
    @Id(autoincrement = true)
    private Long id;
    /**
     * 标题
     */
    private String title;
    /**
     * 主题地址
     */
    private String themeUrl;
    /**
     * 创建时刻
     */
    private Long createTime;
    /**
     * 创建人
     */
    private Long createUser;
    @Generated(hash = 1486170287)
    public TodoListBean(Long id, String title, String themeUrl, Long createTime,
            Long createUser) {
        this.id = id;
        this.title = title;
        this.themeUrl = themeUrl;
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
    public String getThemeUrl() {
        return this.themeUrl;
    }
    public void setThemeUrl(String themeUrl) {
        this.themeUrl = themeUrl;
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

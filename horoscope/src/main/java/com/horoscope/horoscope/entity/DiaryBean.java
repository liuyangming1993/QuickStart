package com.horoscope.horoscope.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity(nameInDb = "diary")
public class DiaryBean {
    @Id(autoincrement = true)
    private Long id;
    /**
     * 日记本名
     */
    private String diaryName;
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
    @Generated(hash = 1449441368)
    public DiaryBean(Long id, String diaryName, String themeUrl, Long createTime,
            Long createUser) {
        this.id = id;
        this.diaryName = diaryName;
        this.themeUrl = themeUrl;
        this.createTime = createTime;
        this.createUser = createUser;
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
    public String getDiaryName() {
        return this.diaryName;
    }
    public void setDiaryName(String diaryName) {
        this.diaryName = diaryName;
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

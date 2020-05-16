package com.horoscope.horoscope.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "diary")
public class DiaryBean {
    @Id(autoincrement = true)
    @NotNull
    private Long id;
    /**
     * 日记本名
     */
    private String diaryName;
    /**
     * 创建时刻
     */
    private Long createTime;
    /**
     * 创建人
     */
    private Long createUser;
    @Generated(hash = 1673327307)
    public DiaryBean(@NotNull Long id, String diaryName, Long createTime,
            Long createUser) {
        this.id = id;
        this.diaryName = diaryName;
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

package com.horoscope.horoscope.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "user")
public class UserBean {
    @Id
    @NotNull
    private Long id;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 生日
     */
    private String birthday;
    @Generated(hash = 969280859)
    public UserBean(@NotNull Long id, String nickname, String birthday) {
        this.id = id;
        this.nickname = nickname;
        this.birthday = birthday;
    }
    @Generated(hash = 1203313951)
    public UserBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNickname() {
        return this.nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getBirthday() {
        return this.birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}

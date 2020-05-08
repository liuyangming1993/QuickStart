package com.horoscope.horoscope.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "article")
public class ArticleBean {
    @Id
    @NotNull
    private Long id;

    @Generated(hash = 1877978817)
    public ArticleBean(@NotNull Long id) {
        this.id = id;
    }

    @Generated(hash = 392728754)
    public ArticleBean() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

package com.horoscope.horoscope.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "todo")
public class TodoBean {
    @Id(autoincrement = true)
    @NotNull
    private Long id;
    /**
     * todo列表id
     */
    private Long todoListId;
    /**
     * 内容
     */
    private String content;
    /**
     * 是否完成：true->done
     */
    private boolean state;
    /**
     * 序号
     */
    private int serialNumber;
    /**
     * 创建时刻
     */
    private Long createTime;
    /**
     * 创建人
     */
    private Long createUser;
    @Generated(hash = 630990449)
    public TodoBean(@NotNull Long id, Long todoListId, String content,
            boolean state, int serialNumber, Long createTime, Long createUser) {
        this.id = id;
        this.todoListId = todoListId;
        this.content = content;
        this.state = state;
        this.serialNumber = serialNumber;
        this.createTime = createTime;
        this.createUser = createUser;
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
    public Long getTodoListId() {
        return this.todoListId;
    }
    public void setTodoListId(Long todoListId) {
        this.todoListId = todoListId;
    }
    public String getContent() {
        return this.content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public boolean getState() {
        return this.state;
    }
    public void setState(boolean state) {
        this.state = state;
    }
    public int getSerialNumber() {
        return this.serialNumber;
    }
    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
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

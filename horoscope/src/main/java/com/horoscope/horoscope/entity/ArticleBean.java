package com.horoscope.horoscope.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "article")
public class ArticleBean {
    @Id(autoincrement = true)
    private Long id;
    /**
     * 日记本id
     */
    private Long diaryId;
    /**
     * 文章标题
     */
    private String title;
    /**
     * 文章内容
     */
    private String content;
    /**
     * 天气
     */
    private String weather;
    /**
     * 心情
     */
    private String mood;
    /**
     * 地点
     */
    private String location;
    /**
     * 日期
     */
    private Long dateTime;
    /**
     * 时区id
     */
    private String timezoneId;
    /**
     * 开头图片
     */
    private String beginImage;
    /**
     * 结尾图片
     */
    private String endImage;
    /**
     * 星座信息
     */
    private String horoscope;
    /**
     * 是否显示星座信息
     */
    private boolean hasHoroscope;
    /**
     * 主题地址
     */
    private String themeUrl;
    /**
     * 主题透明度
     */
    private float themeAlpha;
    /**
     * 创建时刻
     */
    private Long createTime;
    /**
     * 创建人
     */
    private Long createUser;
    @Generated(hash = 1804439659)
    public ArticleBean(Long id, Long diaryId, String title, String content,
            String weather, String mood, String location, Long dateTime,
            String timezoneId, String beginImage, String endImage, String horoscope,
            boolean hasHoroscope, String themeUrl, float themeAlpha,
            Long createTime, Long createUser) {
        this.id = id;
        this.diaryId = diaryId;
        this.title = title;
        this.content = content;
        this.weather = weather;
        this.mood = mood;
        this.location = location;
        this.dateTime = dateTime;
        this.timezoneId = timezoneId;
        this.beginImage = beginImage;
        this.endImage = endImage;
        this.horoscope = horoscope;
        this.hasHoroscope = hasHoroscope;
        this.themeUrl = themeUrl;
        this.themeAlpha = themeAlpha;
        this.createTime = createTime;
        this.createUser = createUser;
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
    public Long getDiaryId() {
        return this.diaryId;
    }
    public void setDiaryId(Long diaryId) {
        this.diaryId = diaryId;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return this.content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getWeather() {
        return this.weather;
    }
    public void setWeather(String weather) {
        this.weather = weather;
    }
    public String getMood() {
        return this.mood;
    }
    public void setMood(String mood) {
        this.mood = mood;
    }
    public String getLocation() {
        return this.location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public Long getDateTime() {
        return this.dateTime;
    }
    public void setDateTime(Long dateTime) {
        this.dateTime = dateTime;
    }
    public String getTimezoneId() {
        return this.timezoneId;
    }
    public void setTimezoneId(String timezoneId) {
        this.timezoneId = timezoneId;
    }
    public String getBeginImage() {
        return this.beginImage;
    }
    public void setBeginImage(String beginImage) {
        this.beginImage = beginImage;
    }
    public String getEndImage() {
        return this.endImage;
    }
    public void setEndImage(String endImage) {
        this.endImage = endImage;
    }
    public String getHoroscope() {
        return this.horoscope;
    }
    public void setHoroscope(String horoscope) {
        this.horoscope = horoscope;
    }
    public boolean getHasHoroscope() {
        return this.hasHoroscope;
    }
    public void setHasHoroscope(boolean hasHoroscope) {
        this.hasHoroscope = hasHoroscope;
    }
    public String getThemeUrl() {
        return this.themeUrl;
    }
    public void setThemeUrl(String themeUrl) {
        this.themeUrl = themeUrl;
    }
    public float getThemeAlpha() {
        return this.themeAlpha;
    }
    public void setThemeAlpha(float themeAlpha) {
        this.themeAlpha = themeAlpha;
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

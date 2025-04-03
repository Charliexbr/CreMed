package com.peiz.caremed.entity;

public class MyStaff {
    private int id;
    private String nickname;
    private String avatar;
    private String sex;
    private int age;
    private String mobile;
    private String sex_text;  // 修改为符合数据库命名
    private String odmanar_text; // 修改为符合数据库命名
    private String master_text;  // 修改为符合数据库命名
    private String status_text;  // 修改为符合数据库命名
    private String status_time_text;  // 修改为符合数据库命名
    private String avatar_url;  // 修改为符合数据库命名

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSex_text() {
        return sex_text;
    }

    public void setSex_text(String sex_text) {
        this.sex_text = sex_text;
    }

    public String getOdmanar_text() {
        return odmanar_text;
    }

    public void setOdmanar_text(String odmanar_text) {
        this.odmanar_text = odmanar_text;
    }

    public String getMaster_text() {
        return master_text;
    }

    public void setMaster_text(String master_text) {
        this.master_text = master_text;
    }

    public String getStatus_text() {
        return status_text;
    }

    public void setStatus_text(String status_text) {
        this.status_text = status_text;
    }

    public String getStatus_time_text() {
        return status_time_text;
    }

    public void setStatus_time_text(String status_time_text) {
        this.status_time_text = status_time_text;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }
}

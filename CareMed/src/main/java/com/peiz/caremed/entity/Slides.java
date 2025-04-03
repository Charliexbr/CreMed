package com.peiz.caremed.entity;

public class Slides {
    private int id;
    private String pic_image;
    private String stype;
    private String title;
    private String stypeText;
    private String pic_image_url;
    private String stype_link;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getpic_image() {
        return pic_image;
    }

    public void setpic_image(String pic_image) {
        this.pic_image = pic_image;
    }

    public String getStype() {
        return stype;
    }

    public void setStype(String stype) {
        this.stype = stype;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStypeText() {
        return stypeText;
    }

    public void setStypeText(String stypeText) {
        this.stypeText = stypeText;
    }

    public String getpic_image_url() {
        return pic_image_url;
    }

    public void setpic_image_url(String pic_image_url) {
        this.pic_image_url = pic_image_url;
    }

    public String getstype_link() {
        return stype_link;
    }

    public void setstype_link(String stype_link) {
        this.stype_link = stype_link;
    }
}

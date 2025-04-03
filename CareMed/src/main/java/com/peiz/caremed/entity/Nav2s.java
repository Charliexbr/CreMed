package com.peiz.caremed.entity;

public class Nav2s {
    private int id;
    private String pic_image;  // 修改为符合数据库命名
    private String stype;      // 修改为符合数据库命名
    private String stype_link; // 修改为符合数据库命名
    private String title;
    private String tcolor;     // 修改为符合数据库命名
    private String cat_text;   // 修改为符合数据库命名
    private String stype_text; // 修改为符合数据库命名
    private String pic_image_url; // 修改为符合数据库命名

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPic_image() {
        return pic_image;
    }

    public void setPic_image(String pic_image) {
        this.pic_image = pic_image;
    }

    public String getStype() {
        return stype;
    }

    public void setStype(String stype) {
        this.stype = stype;
    }

    public String getStype_link() {
        return stype_link;
    }

    public void setStype_link(String stype_link) {
        this.stype_link = stype_link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTcolor() {
        return tcolor;
    }

    public void setTcolor(String tcolor) {
        this.tcolor = tcolor;
    }

    public String getCat_text() {
        return cat_text;
    }

    public void setCat_text(String cat_text) {
        this.cat_text = cat_text;
    }

    public String getStype_text() {
        return stype_text;
    }

    public void setStype_text(String stype_text) {
        this.stype_text = stype_text;
    }

    public String getPic_image_url() {
        return pic_image_url;
    }

    public void setPic_image_url(String pic_image_url) {
        this.pic_image_url = pic_image_url;
    }
}

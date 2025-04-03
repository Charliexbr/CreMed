package com.peiz.caremed.entity;

import java.math.BigDecimal;

public class Services {
    private int id;
    private String code;
    private String stype;
    private String name;
    private String intro;
    private BigDecimal price;
    private BigDecimal priceo;
    private int use_switch;
    private String stype_text;
    private String icon_image_url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStype() {
        return stype;
    }

    public void setStype(String stype) {
        this.stype = stype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPriceo() {
        return priceo;
    }

    public void setPriceo(BigDecimal priceo) {
        this.priceo = priceo;
    }

    public int getUse_switch() {
        return use_switch;
    }

    public void setUse_switch(int use_switch) {
        this.use_switch = use_switch;
    }

    public String getStype_text() {
        return stype_text;
    }

    public void setStype_text(String stype_text) {
        this.stype_text = stype_text;
    }


    public String getIcon_image_url() {
        return icon_image_url;
    }

    public void setIcon_image_url(String icon_image_url) {
        this.icon_image_url = icon_image_url;
    }
}

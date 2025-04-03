package com.peiz.caremed.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;

public class Order {
    private int id;                        // 对应 id 字段
    @JsonProperty("tel")
    private String phone;                  // 对应 phone 字段
    private String service_logo_image_url; // 对应 service_logo_image_url 字段
    private String service_name;           // 对应 service_name 字段
    private String hospital_name;          // 对应 hospital_name 字段
    private String area_name;
    private Timestamp starttime;
    private String client_name;            // 对应 client_name 字段
    private String trade_state;            // 对应 trade_state 字段
    private String out_trade_no;           // 对应 out_trade_no 字段
    private String service_stype;

    public String getService_stype() {
        return service_stype;
    }

    public void setService_stype(String service_stype) {
        this.service_stype = service_stype;
    }

    // Getter 和 Setter 方法
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getService_logo_image_url() {
        return service_logo_image_url;
    }

    public void setService_logo_image_url(String service_logo_image_url) {
        this.service_logo_image_url = service_logo_image_url;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public String getHospital_name() {
        return hospital_name;
    }

    public void setHospital_name(String hospital_name) {
        this.hospital_name = hospital_name;
    }

    public String getArea_name() {
        return area_name;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    public long getStarttime() {
        return starttime.getTime();
    }

    public void setStarttime(Timestamp starttime) {
        this.starttime = starttime;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getTrade_state() {
        return trade_state;
    }

    public void setTrade_state(String trade_state) {
        this.trade_state = trade_state;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }
}
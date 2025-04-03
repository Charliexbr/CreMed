package com.peiz.caremed.dto;

import java.math.BigDecimal;

public class HospitalServiceDTO {
    private int id;                // 对应 id
    private String name;           // 对应 name
    private int service_id;        // 对应 service_id
    private BigDecimal service_price; // 对应 service_price

    // Getter 和 Setter 方法
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public BigDecimal getService_price() {
        return service_price;
    }

    public void setService_price(BigDecimal service_price) {
        this.service_price = service_price;
    }
}
package com.peiz.caremed.dto;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

public class ApiResponse<T> {
    private T data;
    private String msg;
    private int code;

    // 构造方法
    public ApiResponse(T data, String msg, int code) {
        this.data = data;
        this.msg = msg;
        this.code = code;
    }

    // 工厂方法
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(data, "发送成功", 10000);
    }

    public static <T> ApiResponse<T> error(String msg, int code) {
        return new ApiResponse<>(null, msg, code);
    }

    // 新的工厂方法：支持嵌套结构
    public static ApiResponse<Map<String, Object>> tokenResponse(String token) {
        Map<String, Object> nestedData = new HashMap<>();
        nestedData.put("token", token);
        return new ApiResponse<>(nestedData, "验证通过", 10000);
    }

    // Getters 和 Setters
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    // 转成 JSON 字符串
    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}

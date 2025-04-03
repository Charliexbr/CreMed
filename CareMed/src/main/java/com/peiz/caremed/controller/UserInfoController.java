package com.peiz.caremed.controller;

import com.peiz.caremed.entity.Statistics;
import com.peiz.caremed.service.UserInfoService;
import com.peiz.caremed.entity.Users;
import com.peiz.caremed.utils.JwtUtil; // 确保导入JwtUtil
import com.auth0.jwt.interfaces.DecodedJWT; // 引入JWT解码的类
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private JwtUtil jwtUtil;  // 注入JwtUtil工具类

    // 处理获取用户信息的请求
    @GetMapping("/User/index")
    public Map<String, Object> getUsersByPhone(@RequestHeader("token") String token) {
        // 解码 token 获取电话号码
        String mobile = jwtUtil.getClaim(token, "phoneNumber");  // 直接调用 getClaim 方法获取 phone 信息

        Users users = userInfoService.getUsersByPhone(mobile);
        Statistics statistics = userInfoService.getStatisticsByMobile(mobile);
        // 构造响应数据
        Map<String, Object> data = new HashMap<>();
        data.put("mine", users); // 将 List<Users> 放入 "mine" 字段
        data.put("statistic",statistics);
        Map<String, Object> response = new HashMap<>();
        response.put("data", data); // 将 "mine" 放入 "data" 字段
        response.put("msg", "");
        response.put("code", 10000);
        return response;
    }
}

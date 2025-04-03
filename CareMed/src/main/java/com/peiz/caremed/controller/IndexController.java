package com.peiz.caremed.controller;

import com.peiz.caremed.entity.*;
import com.peiz.caremed.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class IndexController {

    @Autowired
    private IndexService indexService;

    @GetMapping("/Index/index")
    public Map<String, Object> getIndex(@RequestParam long aid) {
        List<Slides> slides = indexService.getSlides();
        List<Nav2s> nav2s = indexService.getNav2s();
        List<Navs> navs = indexService.getNavs();
        List<Hospitals> hospitals = indexService.getHospitalByAid(aid);
        List<MyStaff> myStaff = indexService.getMyStaff();
        Map<String, Object> data = new HashMap<>();
        data.put("slides", slides);
        data.put("nav2s", nav2s);
        data.put("navs", navs);
        data.put("hospitals", hospitals);
        data.put("my_staff", myStaff);
        Map<String, Object> response = new HashMap<>();
        response.put("data", data);
        response.put("msg", "");
        response.put("code", 10000);
        return response;
    }
}
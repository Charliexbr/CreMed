package com.peiz.caremed.controller;

import com.peiz.caremed.entity.Hospitals;
import com.peiz.caremed.entity.Services;
import com.peiz.caremed.service.HospitalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
public class HospitalsController {

    @Autowired
    private HospitalsService HospitalsService;
    @GetMapping("/Hospital/index")
    public Map<String, Object> getHospitalByid(@RequestParam int hid) {
        int id = hid;
        Hospitals hospitals = HospitalsService.getHospitalByAid(id);
        List<Services> services = HospitalsService.getServices();
        Map<String, Object> data = new HashMap<>();
        data.put("hospital", hospitals);
        data.put("services", services);
        Map<String, Object> response = new HashMap<>();
        response.put("msg", "");
        response.put("code", 10000);
        response.put("data", data);
        return response;
    }

}

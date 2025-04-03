package com.peiz.caremed.service;

import com.peiz.caremed.dao.HospitalsMapper;
import com.peiz.caremed.entity.Hospitals;
import com.peiz.caremed.entity.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalsService {
    @Autowired
    private HospitalsMapper hospitalsMapper;
    public Hospitals getHospitalByAid(int id) {
        return hospitalsMapper.findHospitalByAid(id);
    }
    public List<Services> getServices() {
        return hospitalsMapper.findServices();
    }
}

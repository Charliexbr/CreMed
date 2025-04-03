package com.peiz.caremed.service;

import com.peiz.caremed.dao.IndexMapper;
import com.peiz.caremed.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexService {

    @Autowired
    private IndexMapper indexMapper;

    /**
     * 根据 aid 查询医院信息
     *
     * @param aid 医院的 aid
     * @return 医院信息
     */
    public List<Hospitals> getHospitalByAid(long aid) {
        return indexMapper.findHospitalByAid(aid);
    }
    public List<Slides> getSlides() {
        return indexMapper.findSlides();
    }
    public List<Nav2s> getNav2s() {
        return indexMapper.findNav2s();
    }
    public List<Navs> getNavs() {
        return indexMapper.findNavs();
    }
    public List<MyStaff> getMyStaff() {
        return indexMapper.findMyStaff();
    }
}

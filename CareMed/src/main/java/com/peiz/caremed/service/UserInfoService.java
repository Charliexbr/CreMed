package com.peiz.caremed.service;


import com.peiz.caremed.dao.UserInfoMapper;
import com.peiz.caremed.entity.Statistics;
import com.peiz.caremed.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    // 通过手机号码查询用户信息
    public Users getUsersByPhone(String phone) {
        return userInfoMapper.findUsersByPhone(phone);
    }
    public Statistics getStatisticsByMobile(String mobile) {
        return userInfoMapper.findStatisticsByMobile(mobile);
    }
}


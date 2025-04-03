package com.peiz.caremed.dao;

import com.peiz.caremed.entity.Statistics;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import com.peiz.caremed.entity.Users;
@Mapper
public interface UserInfoMapper {

    @Select("SELECT * FROM users WHERE mobile = #{mobile}")
    Users findUsersByPhone(String mobile);
    @Select("SELECT s.* FROM statistics s " +
            "JOIN users u ON s.user_id = u.id " +
            "WHERE u.mobile = #{mobile}")
    Statistics findStatisticsByMobile(String mobile);
}


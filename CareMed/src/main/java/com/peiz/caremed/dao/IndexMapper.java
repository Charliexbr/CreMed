package com.peiz.caremed.dao;

import com.peiz.caremed.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IndexMapper {

    @Select("SELECT * FROM hospitals WHERE aid = #{aid}")
    List<Hospitals> findHospitalByAid(long aid);
    @Select("SELECT * FROM slides")
    List<Slides> findSlides();
    @Select("SELECT * FROM nav2s")
    List<Nav2s> findNav2s();
    @Select("SELECT * FROM navs")
    List<Navs> findNavs();
    @Select("SELECT * FROM my_staff")
    List<MyStaff> findMyStaff();
}
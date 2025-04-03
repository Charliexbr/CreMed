package com.peiz.caremed.dao;

import com.peiz.caremed.entity.Hospitals;
import com.peiz.caremed.entity.Services;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface HospitalsMapper {
    @Select("SELECT * FROM hospitals WHERE id = #{id}")
    Hospitals findHospitalByAid(int id);
    @Select("SELECT * FROM services")
    List<Services> findServices();
}

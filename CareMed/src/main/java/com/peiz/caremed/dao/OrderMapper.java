package com.peiz.caremed.dao;

import com.peiz.caremed.dto.HospitalServiceDTO;
import com.peiz.caremed.entity.Client;
import com.peiz.caremed.entity.Order;
import com.peiz.caremed.entity.Services;
import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface OrderMapper {
    @Select("SELECT * FROM services WHERE id = #{id}")
    Services findServicesById(int id);
    @Select("SELECT h.id AS id, h.name AS name, s.id AS service_id, s.price AS service_price " +
            "FROM hospitals h, services s " +
            "WHERE s.id = #{serviceId}")
    List<HospitalServiceDTO> getHospitalServiceByServiceId(int serviceId);
    @Select("SELECT * FROM `order` WHERE phone = #{phone} AND trade_state = #{trade_state}")
    List<Order> getOrderByPhoneAndState(@Param("phone") String phone, @Param("trade_state") String trade_state);
    @Select("SELECT * FROM `order` WHERE phone = #{phone}")
    List<Order> getALLOrderByPhone(String phone);
    @Insert("INSERT INTO `order` (phone, service_name, hospital_name, starttime, client_name, trade_state, service_stype) " +
            "VALUES (#{phone}, #{service_name}, #{hospital_name}, #{starttime}, #{client_name}, #{trade_state}, #{service_stype})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = int.class)
    int insertOrder(@Param("phone") String phone,
                    @Param("service_name") String serviceName,
                    @Param("hospital_name") String hospitalName,
                    @Param("starttime") Timestamp startTime,
                    @Param("client_name") String clientName,
                    @Param("trade_state") int tradeState,
                    @Param("service_stype") String serviceStype);
    @Select("SELECT LAST_INSERT_ID()")
    int getLastInsertId();
    @Select("SELECT * FROM clients")
    List<Client> getAllClients();
    @Update("UPDATE `order` SET client_name = #{name} WHERE id = #{id}")
    int updateOrderNameById(@Param("id") int id, @Param("name") String name);
    @Update("UPDATE `order` SET trade_state = 3 WHERE id = #{id}")
    int updateOrderStateById(int id);
    @Update("UPDATE `order` SET trade_state = 4 WHERE id = #{id}")
    int updateOrderStateById2(int id);
    @Delete("DELETE FROM `order` WHERE id = #{id}")
    int deleteOrderById(int id);
}


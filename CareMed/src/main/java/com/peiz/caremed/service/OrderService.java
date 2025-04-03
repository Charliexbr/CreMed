package com.peiz.caremed.service;

import com.peiz.caremed.dao.OrderMapper;
import com.peiz.caremed.dto.HospitalServiceDTO;
import com.peiz.caremed.entity.Client;
import com.peiz.caremed.entity.Order;
import com.peiz.caremed.entity.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;
    public List<HospitalServiceDTO> getHospitalServiceInfo(int id) {
        return orderMapper.getHospitalServiceByServiceId(id);
    }
    public Services findServicesById(int id) {
        return orderMapper.findServicesById(id);
    }
    public List<Order> getOrderByPhone(String phone,String trade_state) {
        return orderMapper.getOrderByPhoneAndState(phone,trade_state);
    }
    public List<Order> getALLOrderByPhone(String phone) {
        return orderMapper.getALLOrderByPhone(phone);
    }
    public int createOrder(String phone, String serviceName, String hospitalName,
                           Timestamp timestamp, String clientName, int trade_state, String service_stype) {
        // 调用 OrderMapper 的 insertOrder 方法插入订单并返回生成的 ID
        return orderMapper.insertOrder(phone, serviceName, hospitalName, timestamp, clientName, trade_state, service_stype);
    }
    public int getLastInsertId() {
        return orderMapper.getLastInsertId();
    }
    public List<Client> getAllClients() {
        return orderMapper.getAllClients();
    }
    public boolean updateOrderName(int id, String name) {
        int rowsAffected = orderMapper.updateOrderNameById(id, name);
        return rowsAffected > 0;
    }
    public int updateOrderState(int id) {
        return orderMapper.updateOrderStateById(id);
    }
    public int updateOrderState2(int id) {
        return orderMapper.updateOrderStateById2(id);
    }
    public int deleteOrder(int id) {
        return orderMapper.deleteOrderById(id);
    }
}

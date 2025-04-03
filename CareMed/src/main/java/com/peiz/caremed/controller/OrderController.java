package com.peiz.caremed.controller;

import com.peiz.caremed.dto.ApiResponse;
import com.peiz.caremed.dto.HospitalServiceDTO;
import com.peiz.caremed.entity.Client;
import com.peiz.caremed.entity.Order;
import com.peiz.caremed.entity.Services;
import com.peiz.caremed.service.OrderService;
import com.peiz.caremed.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private JwtUtil jwtUtil;
    @GetMapping("Service/order")
    public Map<String, Object> getHospitalByid(@RequestParam int svid) {
        int id = svid;
        Services service = orderService.findServicesById(id);
        List<HospitalServiceDTO> hospitalServiceInfo = orderService.getHospitalServiceInfo(id);
        Map<String, Object> data = new HashMap<>();
        data.put("service", service);
        data.put("hospitals", hospitalServiceInfo);
        Map<String, Object> response = new HashMap<>();
        response.put("msg", "");
        response.put("code", 10000);
        response.put("data", data);
        return response;
    }
    @GetMapping("/order/list")
    public Map<String, Object> getOrderDetail(@RequestHeader("token") String token, @RequestParam("state") String state) {

            //System.out.println("token: " + token);
            String phone = jwtUtil.getClaim(token, "phoneNumber");
            //System.out.println("phone: " + phone);
            String trade_state = state;
            //System.out.println("trade_state: " + trade_state);
            List<Order> order;
            if ("undefined".equals(state) || state == null || "".equals(state)) {
                order = orderService.getALLOrderByPhone(phone);
            } else {
                order = orderService.getOrderByPhone(phone, trade_state);
            }
            Map<String, Object> data = new HashMap<>();

            Map<String, Object> response = new HashMap<>();
            response.put("msg", "");
            response.put("code", 10000);
            response.put("data", order);
            return response;

    }
    @PostMapping("Order/create")
    public Map<String, Object> createOrder(@RequestBody Map<String, Object> params) {
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        try {
            // 提取嵌套的参数
            Map<String, Object> nestedParams = (Map<String, Object>) params.get("params");
            int trade_state = (int) nestedParams.get("trade_state");
            String phone = (String) nestedParams.get("tel");
            String service_name = (String) nestedParams.get("service_name");
            String hospital_name = (String) nestedParams.get("hospital_name");
            String service_stype = (String) nestedParams.get("service_stype");
            long start_time = (long) nestedParams.get("starttime");
            String client_name = (String) nestedParams.getOrDefault("client_name", "随机分配");

            Timestamp timestamp = new Timestamp(start_time);

            // 插入订单
            int row = orderService.createOrder(phone, service_name, hospital_name, timestamp, client_name, trade_state, service_stype);

            // 获取插入的主键 ID
            int orderId = orderService.getLastInsertId();

            if (row > 0) {
                data.put("orderId", orderId);

                // 成功插入，返回成功信息
                response.put("data", data);
                response.put("code", 10000);
                response.put("message", "订单创建成功");
                response.put("orderId", orderId);
            } else {
                // 插入失败
                response.put("code", 500);
                response.put("message", "订单创建失败，请稍后重试");
            }
        } catch (Exception e) {
            // 异常处理
            response.put("code", 500);
            response.put("message", "服务器异常: " + e.getMessage());
        }

        return response;
    }

    @GetMapping("User/clients")
    public Map<String, Object> getAllClients() {
        List<Client> personclients;
        personclients  = orderService.getAllClients();
        Map<String, Object> data = new HashMap<>();
        data.put("clients", personclients);
        Map<String, Object> response = new HashMap<>();
        response.put("msg", "");
        response.put("code", 10000);
        response.put("data", data);
        return response;
    }
    @PostMapping("Order/update")
    public Map<String, Object> updateOrderName(@RequestBody Map<String, Object> requestData) {
        int id = (int) requestData.get("orderId");
        String name = (String) requestData.get("clientName");
        System.out.println(name);
        orderService.updateOrderName(id, name);
        orderService.updateOrderState(id);
        Map<String, Object> response = new HashMap<>();
        response.put("msg", "");
        response.put("code", 10000);
        return response;
    }
    @PostMapping("Order/cancel")
    public Map<String, Object> updateOrderName2(@RequestBody Map<String, Object> requestData) {
        int id = (int) requestData.get("id");
        orderService.updateOrderState2(id);
        Map<String, Object> response = new HashMap<>();
        response.put("msg", "");
        response.put("code", 10000);
        return response;
    }
    @PostMapping("Order/delete")
    public Map<String, Object> deleteOrder(@RequestBody Map<String, Object> requestData) {
        int id = (int) requestData.get("id");
        orderService.deleteOrder(id);
        Map<String, Object> response = new HashMap<>();
        response.put("msg", "");
        response.put("code", 10000);
        return response;
    }

}

package com.peiz.caremed.controller;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.tea.TeaException;
import com.aliyun.teautil.models.RuntimeOptions;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.peiz.caremed.dto.ApiResponse;
import com.peiz.caremed.utils.JwtUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/sms")
public class SmsController {

    private final Map<String, String> verificationCodes = new HashMap<>();

    /**
     * 初始化阿里云短信Client
     *
     * @return Client
     * @throws Exception 异常信息
     */
    private Client createClient() throws Exception {
        com.aliyun.teaopenapi.models.Config config = new com.aliyun.teaopenapi.models.Config()
        config.endpoint = "dysmsapi.aliyuncs.com";
        return new Client(config);
    }

    /**
     * 发送短信接口
     *
     * @param request 请求体，包含手机号
     * @return ResponseEntity 响应结果
     */
    @PostMapping("/send")
    public ResponseEntity<?> sendSms(@RequestBody Map<String, String> request) {
        String tel = request.get("tel");
        if (tel == null || tel.isEmpty()) {
            return ResponseEntity.badRequest().body("手机号码不能为空");
        }

        // 生成随机验证码
        String verificationCode = String.valueOf(new Random().nextInt(9000) + 1000);

        try {
            // 创建短信发送请求
            Client client = createClient();
            SendSmsRequest sendSmsRequest = new SendSmsRequest()
                    .setSignName("阿里云短信测试")
                    .setTemplateCode("SMS_154950909")
                    .setPhoneNumbers(tel)
                    .setTemplateParam("{\"code\":\"" + verificationCode + "\"}");

            // 发送短信
            RuntimeOptions runtime = new RuntimeOptions();
            client.sendSmsWithOptions(sendSmsRequest, runtime);

            // 保存验证码（生产环境应使用Redis等存储）
            verificationCodes.put(tel, verificationCode);

            return ResponseEntity.ok(ApiResponse.success(""));
        } catch (TeaException error) {
            // 打印并记录错误信息
            System.err.println("错误信息: " + error.getMessage());
            if (error.getData() != null) {
                System.err.println("诊断地址: " + error.getData().get("Recommend"));
            }

            // 返回详细错误响应
            return ResponseEntity.status(500).body("短信发送失败: " + error.getMessage());
        } catch (Exception e) {
            // 通用异常处理
            System.err.println("未知错误: " + e.getMessage());
            return ResponseEntity.status(500).body("短信发送失败: 系统内部错误");
        }
    }

    @PostMapping("/verify")
    public ResponseEntity<?> verifySms(@RequestBody Map<String, String> request) {
        // 从请求体中提取参数
        String tel = request.get("tel");
        String code = request.get("code");

        if (tel == null || tel.isEmpty()) {
            return ResponseEntity.badRequest().body(ApiResponse.error("手机号码不能为空", 400));
        }

        if (code == null || code.isEmpty()) {
            return ResponseEntity.badRequest().body(ApiResponse.error("验证码不能为空", 400));
        }

        // 获取存储的验证码
        String savedCode = verificationCodes.get(tel);

        if (savedCode != null && savedCode.equals(code)) {
            // 验证成功，生成JWT Token
            Map<String, Object> claims = new HashMap<>();
            claims.put("phoneNumber", tel); // 添加手机号作为自定义载荷

            long expirationMillis = 24 * 60 * 60 * 1000; // 设置过期时间为24小时
            String token = JwtUtil.generateToken(claims, expirationMillis); // 调用工具类生成Token

            // 返回验证成功和Token
            return ResponseEntity.ok(ApiResponse.tokenResponse(token));
        } else {
            return ResponseEntity.status(400).body(ApiResponse.error("验证码错误或已过期", 400));
        }
    }


}

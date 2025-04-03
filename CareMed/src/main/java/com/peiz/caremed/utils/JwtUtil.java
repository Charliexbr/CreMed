package com.peiz.caremed.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Component
public class JwtUtil {

    // 秘钥
    private static final String SECRET = "peiz"; // 请替换为更安全的密钥

    // 签发者
    private static final String ISSUER = "CareMed";

    /**
     * 生成 JWT Token
     *
     * @param claims 自定义的载荷数据（例如手机号等）
     * @param expirationMillis Token 有效期（毫秒）
     * @return 生成的 Token
     */
    public static String generateToken(Map<String, Object> claims, long expirationMillis) {
        // 设置过期时间
        Date now = new Date();
        Date expiration = new Date(now.getTime() + expirationMillis);

        // 打印出传入的 claims 信息，以便调试
        System.out.println("Claims before generating token: " + claims);

        // 构造 Token
        String token = JWT.create()
                .withIssuer(ISSUER) // 设置签发者
                .withIssuedAt(now) // 签发时间
                .withExpiresAt(expiration) // 过期时间
                .withPayload(claims) // 添加自定义载荷
                .sign(Algorithm.HMAC256(SECRET)); // 使用 HMAC256 签名

        // 打印生成的 Token
        //System.out.println("Generated Token: " + token);
        return token;
    }

    /**
     * 解析 JWT Token
     *
     * @param token 待解析的 Token
     * @return 解析后的数据（DecodedJWT）
     * @throws JWTVerificationException 如果 Token 无效或过期
     */
    public static DecodedJWT verifyToken(String token) throws JWTVerificationException {
        // 创建验证器
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET))
                .withIssuer(ISSUER) // 验证签发者
                .build();

        // 验证并解析 Token
        return verifier.verify(token);
    }

    /**
     * 从 Token 中提取自定义字段
     *
     * @param token Token 字符串
     * @param key 字段名
     * @return 字段值
     */
    public static String getClaim(String token, String key) {
        // 验证并解析 Token
        DecodedJWT decodedJWT = verifyToken(token);

        // 获取并打印解析的 claim
        String claimValue = decodedJWT.getClaim(key).asString();
        //System.out.println("Parsed Claim for '" + key + "': " + claimValue);

        return claimValue;
    }
}


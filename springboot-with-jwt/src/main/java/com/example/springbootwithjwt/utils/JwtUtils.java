package com.example.springbootwithjwt.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.Map;

/**
 * JWT工具类
 * @author hanbing
 * @date 2024-03-22
 */
public class JwtUtils {

    /**
     * jwt的私钥
     */
    private static final String SECRET_KEY = "%G%^H^G@!@D!F^";

    /**
     * 过期时间 默认30s
     */
    private static final long EXPIRE_TIME = 1000 * 30;

    /**
     * 获取token
     * @param payloadMap 载荷
     * @return token
     */
    public static String getToken (Map<String, String> payloadMap) {
        return getToken(payloadMap, EXPIRE_TIME);
    }

    /**
     * 获取token
     * @param payloadMap 载荷
     * @param expireTime 过期时间
     * @return token
     */
    public static String getToken (Map<String, String> payloadMap, long expireTime) {
        JWTCreator.Builder builder = JWT.create();
        payloadMap.forEach(builder::withClaim);
        builder.withExpiresAt(new Date(System.currentTimeMillis() + expireTime));
        return builder.sign(Algorithm.HMAC256(SECRET_KEY));
    }

    /**
     * 验证token
     * @param token token
     * @return 验证结果
     */
    public static DecodedJWT verifyToken (String token) {
        return JWT.require(Algorithm.HMAC256(SECRET_KEY)).build().verify(token);
    }
}

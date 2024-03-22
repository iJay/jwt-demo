package com.example.jwtquickstart;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Date;

@SpringBootTest
class JwtQuickStartApplicationTests {

    /**
     * 私钥 一定不能泄露
     */
    private static final String secretKey = "%$W^Jg%G^H";

    @Test
    void testCreateToken() {
        Date expDate = new Date(System.currentTimeMillis() + 1000 * 60);
        String token = JWT.create()
                .withClaim("username", "admin") // payload
                .withClaim("userId", 123) // payload
                .withExpiresAt(expDate) // 过期时间
                .sign(Algorithm.HMAC256(secretKey)); // 签名
        System.out.println(token);
    }

    @Test
    void testVerifyToken() {
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(secretKey))
                .build();
        DecodedJWT verify = jwtVerifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE3MTEwNzMzNTQsInVzZXJJZCI6MSwidXNlcm5hbWUiOiJhZG1pbiJ9.bCUfQcvivzskpgYbn-tu3KmNQh2BFfAYX8ShYKZuVKE");
        System.out.println(verify.getClaim("username").asString());
        System.out.println(verify.getClaim("userId").asInt());
    }

}

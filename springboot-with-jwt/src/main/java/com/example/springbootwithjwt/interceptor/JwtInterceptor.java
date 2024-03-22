package com.example.springbootwithjwt.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.example.springbootwithjwt.utils.JwtUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.SignatureException;
import java.util.HashMap;
import java.util.Map;

/**
 * Jwt拦截器 用于验证token
 * @author hanbing
 * @date 2024-03-22
 */
public class JwtInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map<String, Object> resultMap = new HashMap<>();
        String authorization = request.getHeader("Authorization");
        try {
            JwtUtils.verifyToken(authorization);
            // 验证未抛出异常则验证通过 返回true放行
            return true;
        } catch (SignatureVerificationException e) {
            e.printStackTrace();
            resultMap.put("message", "token签名错误");
        } catch (TokenExpiredException e) {
            e.printStackTrace();
            resultMap.put("message", "token已过期");
        } catch (AlgorithmMismatchException e) {
            e.printStackTrace();
            resultMap.put("message", "token算法不一致");
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("message", "token验证失败");
        }
        resultMap.put("code", 500);
        String json = new ObjectMapper().writeValueAsString(resultMap);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(json);
        return false;
    }
}

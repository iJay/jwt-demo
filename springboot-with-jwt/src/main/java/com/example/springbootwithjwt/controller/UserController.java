package com.example.springbootwithjwt.controller;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.springbootwithjwt.entity.User;
import com.example.springbootwithjwt.service.UserService;
import com.example.springbootwithjwt.utils.JwtUtils;
import lombok.AllArgsConstructor;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hanbing
 * @date 2024-03-22
 */
@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody User user) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            User userFromDb  = userService.login(user);
            Map<String, String> payload = new HashMap<>(2);
            payload.put("username", userFromDb.getUsername());
            payload.put("userId", userFromDb.getId().toString());
            String token = JwtUtils.getToken(payload);
            resultMap.put("code", 200);
            resultMap.put("message", "登录成功");
            resultMap.put("token", token);
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("code", 500);
            resultMap.put("message", "登录失败");
        }
        return resultMap;
    }

    @GetMapping("/test")
    public Map<String, Object> test(HttpServletRequest request){
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("code", 200);
        resultMap.put("message", "验证成功");
        return resultMap;
    }
}

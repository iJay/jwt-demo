package com.example.springbootwithjwt.service;

import com.example.springbootwithjwt.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author hanbing
 * @date 2024-03-22
 */
public interface UserService {
    /**
     * 登录
     * @param user 用户
     * @return 用户
     */
    User login(User user);
}

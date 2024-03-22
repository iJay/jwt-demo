package com.example.springbootwithjwt.service.impl;

import com.example.springbootwithjwt.entity.User;
import com.example.springbootwithjwt.mapper.UserMapper;
import com.example.springbootwithjwt.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @author hanbing
 * @date 2024-03-22
 */
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Override
    public User login(User user) {
        User userFromDb = userMapper.login(user);
        if (!ObjectUtils.isEmpty(userFromDb)) {
            return userFromDb;
        }
        throw new RuntimeException("用户名或密码错误");
    }
}

package com.example.springbootwithjwt.mapper;

import com.example.springbootwithjwt.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author hanbing
 * @date 2024-03-22
 */
public interface UserMapper {
    /**
     * 登录
     * @param user 用户
     * @return 用户
     */
    User login(@Param("user") User user);
}

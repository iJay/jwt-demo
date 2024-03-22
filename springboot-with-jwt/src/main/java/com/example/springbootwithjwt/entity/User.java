package com.example.springbootwithjwt.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author hanbing
 * @date 2024-03-22
 */
@Data
public class User implements Serializable {

    /**
     * 序列化id
     */
    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}

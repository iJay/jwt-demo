package com.example.springbootwithjwt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author hblx2
 * @date 2024-03-22
 */
@SpringBootApplication
@MapperScan("com.example.springbootwithjwt.mapper")
public class SpringbootWithJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWithJwtApplication.class, args);
    }

}

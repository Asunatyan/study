package com.dqk.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*
@MapperScan(basePackages = "com.dqk.test.mapper")
*/
public class MybatisPlusTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusTestApplication.class, args);
    }
}

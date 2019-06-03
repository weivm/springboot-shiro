package com.example.demoshiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.demoshiro.dao")
public class DemoShiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoShiroApplication.class, args);
    }

}

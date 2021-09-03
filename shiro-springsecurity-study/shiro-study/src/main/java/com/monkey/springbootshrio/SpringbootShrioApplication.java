package com.monkey.springbootshrio;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.monkey.springbootshrio.mapper")
public class SpringbootShrioApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootShrioApplication.class, args);
    }

}

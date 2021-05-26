package com.ccqstark.small;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ccqstark.small.dao")
public class SmallApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmallApplication.class, args);
    }

}

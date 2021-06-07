package com.ccqstark.small;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.ccqstark.small.dao")
@EnableSwagger2
public class SmallApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmallApplication.class, args);
    }

}

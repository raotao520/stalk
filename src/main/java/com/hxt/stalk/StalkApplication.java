package com.hxt.stalk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.hxt.stalk.dataobject.mapper")
public class StalkApplication {

    public static void main(String[] args) {
        SpringApplication.run(StalkApplication.class, args);
    }

}

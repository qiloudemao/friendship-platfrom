package com.wt.friendship;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan("com.wt.friendship.mapper")
public class UserCenterMasterApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserCenterMasterApplication.class, args);
    }

}

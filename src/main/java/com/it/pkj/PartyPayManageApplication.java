package com.it.pkj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.it.pkj.mapper")
public class PartyPayManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(PartyPayManageApplication.class, args);
    }

}

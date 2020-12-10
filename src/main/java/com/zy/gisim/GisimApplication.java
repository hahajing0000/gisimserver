package com.zy.gisim;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.zy.gisim.mapper")
@SpringBootApplication
public class GisimApplication {

    public static void main(String[] args) {
        SpringApplication.run(GisimApplication.class, args);
    }

}

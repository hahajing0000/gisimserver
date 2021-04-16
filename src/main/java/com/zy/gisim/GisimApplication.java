package com.zy.gisim;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@MapperScan("com.zy.gisim.mapper")
@SpringBootApplication
public class GisimApplication  {//extends SpringBootServletInitializer

    public static void main(String[] args) {
        SpringApplication.run(GisimApplication.class, args);
    }

//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(GisimApplication.class);//super.configure(builder);
//    }
}

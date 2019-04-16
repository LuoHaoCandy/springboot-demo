package com.luohao.springboot;

import com.luohao.springboot.config.ConfigBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({ConfigBean.class})
@MapperScan("com.luohao.springboot.mysql.mapper")

public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

package com.luohao.springboot;
import com.luohao.springboot.config.ConfigBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@EnableAutoConfiguration
public class Example {


    @Resource
    private ConfigBean configBean;

    @RequestMapping("/")
    String home() {
        return configBean.getName();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Example.class, args);
    }

}
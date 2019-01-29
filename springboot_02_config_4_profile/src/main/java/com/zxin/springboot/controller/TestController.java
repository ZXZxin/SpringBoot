package com.zxin.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//只是测试项目是不是出错 /test方法一下
@RestController
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return "test springboot_02_config_4_profile...";
    }
}

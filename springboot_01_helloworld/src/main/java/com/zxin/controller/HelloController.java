package com.zxin.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @ResponseBody // 表示返回的是内容，而不是视图
    @RequestMapping("/hello")
    public String hello(){
        return "Hello SpringBoot!";
    }
}

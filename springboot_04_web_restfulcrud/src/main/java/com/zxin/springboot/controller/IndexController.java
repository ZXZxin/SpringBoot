package com.zxin.springboot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    // 使用另外一种方法 MyMvcConfig中
//    @RequestMapping({"/", "/index.html"})
//    public String index(){
//        return "login";
//    }
}

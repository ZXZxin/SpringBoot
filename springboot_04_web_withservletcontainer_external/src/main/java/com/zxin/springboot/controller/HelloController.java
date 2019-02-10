package com.zxin.springboot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {


    @GetMapping("/tosuccess")
    public String hello(Model model){
        model.addAttribute("msg","你好");
        return "success";
    }
}

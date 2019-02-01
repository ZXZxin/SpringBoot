package com.zxin.springboot.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



// 以前是使用 WebMvcConfigurerAdapter扩展SpringMVC的功能
@EnableWebMvc // 全面接管SpringMVC
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器发送 /zxin请求，来到 success.html页面
        registry.addViewController("/zxin").setViewName("success");
    }

}

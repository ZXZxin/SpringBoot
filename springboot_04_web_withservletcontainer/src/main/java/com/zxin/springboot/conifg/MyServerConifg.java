package com.zxin.springboot.conifg;

import com.zxin.springboot.filter.MyFilter;
import com.zxin.springboot.listener.MyListener;
import com.zxin.springboot.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class MyServerConifg {


    // 注册三大组件 -- Servlet
    @Bean
    public ServletRegistrationBean myServlet(){
        return new ServletRegistrationBean(new MyServlet(),  "/myServlet");
    }

    // 注册Filter
    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/hello", "/myServlet"));
        return filterRegistrationBean;
    }

    // 注册Listener
    @Bean
    public ServletListenerRegistrationBean myListener(){
        return new ServletListenerRegistrationBean<>(new MyListener());
    }
}

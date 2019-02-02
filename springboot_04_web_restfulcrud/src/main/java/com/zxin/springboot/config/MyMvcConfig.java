package com.zxin.springboot.config;


import com.zxin.springboot.component.LoginHandlerInterceptor;
import com.zxin.springboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer{

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        // 重定向的中间页面main.html路径, 防止表单的重复提交
        registry.addViewController("/main.html").setViewName("dashboard");
    }


    // 注册组件
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    // 注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 除了  "/index.html", "/", "/user/login"  都要拦截
        // 以前SpringMVC还需要配置： 不能拦截静态资源，
        // 现在SpringBoot已经做好了不拦截静态资源的配置
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/index.html", "/", "/user/login"
        );
    }
}

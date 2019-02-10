package com.zxin.springboot.conifg;


import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyMvcConfig {

    // SpringBoot2.0废弃的用法
//    @Bean
//    public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer(){
//        return new EmbeddedServletContainerCustomizer(){
//
//            @Override
//            public void customize(ConfigurableEmbeddedServletContainer container){
//                container.setPort(8081);
//            }
//        }
//    }

    // 替代方案
    // 博客 :  https://blog.csdn.net/Hard__ball/article/details/81281898
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer(){
        // 定制嵌入式的Servlet容器相关的规则
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                factory.setPort(8081);
            }
        };
        // 使用lambda表达式
//        return factory -> factory.setPort(8081);
    }
}

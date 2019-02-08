package com.zxin.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

@SpringBootApplication // 包含了 @Configuration
public class SpringBoot04WebPrimary2ThymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot04WebPrimary2ThymeleafApplication.class, args);
	}

	@Bean
	public ViewResolver myViewResolver(){
		return new MyViewResolver();
	}

	private static class MyViewResolver implements ViewResolver{

		@Nullable
		@Override
		public View resolveViewName(String s, Locale locale) throws Exception {
			return null;
		}
	}

}


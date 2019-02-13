package com.zxin.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.zxin.springboot.mapper")
@SpringBootApplication
public class SpringBoot06DataMybatis2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot06DataMybatis2Application.class, args);
	}

}


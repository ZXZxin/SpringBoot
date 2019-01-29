package com.zxin.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

//@ImportResource(locations = {"classpath:beans.xml"}) // 但是Spring不推荐使用配置，而是使用全注解
@SpringBootApplication
public class SpringBoot02Config3PropertySourceImportResourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot02Config3PropertySourceImportResourceApplication.class, args);
	}
}


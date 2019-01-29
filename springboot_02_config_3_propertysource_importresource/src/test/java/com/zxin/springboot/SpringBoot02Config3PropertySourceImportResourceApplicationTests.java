package com.zxin.springboot;

import com.zxin.springboot.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot02Config3PropertySourceImportResourceApplicationTests {

	@Autowired
	@Qualifier("myPerson")
	private Person person;

	@Test
	public void contextLoads() {
		System.out.println(person);
	}

	@Autowired
	private ApplicationContext ioc;

	@Test
	public void testIsContainHelloService(){
		boolean b = ioc.containsBean("helloService01");
		System.out.println(b);
	}
}


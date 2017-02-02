package com.journaldev.spring.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.journaldev.spring.service.AwareInterfaces;

public class RunSpringAware {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring-aware.xml");

		ctx.getBean("myAwareService", AwareInterfaces.class);
		
		ctx.close();
	}

}

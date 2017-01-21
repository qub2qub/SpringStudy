package com.journaldev.spring.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class LC_Annotations {

	@PostConstruct
	public void init(){
		System.out.println("LC_Annotations @PostConstruct method called");
	}
	
	public LC_Annotations(){
		System.out.println("LC_Annotations no-args constructor called");
	}
	
	@PreDestroy
	public void destory(){
		System.out.println("LC_Annotations @PreDestroy method called");
	}
}

package com.journaldev.spring.service;

import com.journaldev.spring.bean.Employee;

public class LC_MethodsOverride {

	private Employee employee;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public LC_MethodsOverride(){
		System.out.println("LC_MethodsOverride no-args constructor called");
	}

	public void destroy() throws Exception {
		System.out.println("LC_MethodsOverride -> destroy() ->  Closing resources");
	}

	public void init() throws Exception {
		System.out.println("LC_MethodsOverride  -> init() -> initializing to dummy value");
		if(employee.getName() == null){
			employee.setName("TestSpring");
		}
	}
}

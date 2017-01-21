package com.journaldev.spring.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import com.journaldev.spring.bean.Employee;

public class LC_ImplementsInterface implements InitializingBean, DisposableBean {

	private Employee employee;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public LC_ImplementsInterface(){
		System.out.println("LC_ImplementsInterface no-args constructor called");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("LC_ImplementsInterface Closing resources <-- DisposableBean");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("LC_ImplementsInterface initializing to dummy value <-- InitializingBean");
		if(employee.getName() == null){
			employee.setName("Pankaj");
		}
	}
}

package com.journaldev.spring.main;

import com.journaldev.spring.service.LC_MethodsOverride;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunSpringLifeCycle {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

		System.out.println("\n__________ Spring Context initialized _________\n");
		
		LC_MethodsOverride service = ctx.getBean("myEmployeeService", LC_MethodsOverride.class);
		//LC_ImplementsInterface service = ctx.getBean("employeeService", LC_ImplementsInterface.class);

		System.out.println("_________Bean retrieved from Spring Context_________");
		
		System.out.println("Employee Name="+service.getEmployee().getName());
		
		ctx.close();
		System.out.println("\n_________ Spring Context Closed _________");
	}

}

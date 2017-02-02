/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.den.jscore.containers.factory;

import by.den.jscore.containers.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author mkonda
 */
public class EmployeeFactoryClient {

    private ApplicationContext ctx = null;

    public void testEmployeeFactory() {
        ctx = new ClassPathXmlApplicationContext("containers-beans.xml");

        EmployeeFactory factory = ctx.getBean("employeeFactory", EmployeeFactory.class);
        Employee emp = factory.createEmployee();
        System.out.println("Employee Factory: " + factory.hashCode());
        System.out.println("Employee: " + emp.hashCode());
    }

    public static void main(String args[]) {
        EmployeeFactoryClient client = new EmployeeFactoryClient();

        client.testEmployeeFactory();;
    }
}

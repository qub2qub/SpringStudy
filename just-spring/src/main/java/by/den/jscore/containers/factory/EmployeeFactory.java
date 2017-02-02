/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.den.jscore.containers.factory;

import by.den.jscore.containers.Employee;

/**
 *
 * @author mkonda
 */
public class EmployeeFactory {

    private static EmployeeFactory instance;

    private EmployeeFactory() {
    }

    public static EmployeeFactory getEmployeeFactory() {

        if (instance == null) {
            instance = new EmployeeFactory();
        }
        return instance;
    }
    
    public Employee createEmployee(){
        return new Employee();
    }
}

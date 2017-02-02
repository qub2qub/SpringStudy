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
public class EmployeeCreator {

    public Employee createEmployee() {
        return new Employee();
    }

    public Employee createExecutive() {
        Employee emp = new Employee();
        emp.setTitle("EXEC");
        emp.setGrade("GRADE-A");
        return emp;
    }
}

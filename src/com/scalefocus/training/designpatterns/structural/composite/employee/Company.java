package com.scalefocus.training.designpatterns.structural.composite.employee;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kristiyan SLavov
 * A Composite that consists of leaf elements and also implements the base component's operation/s.
 * All objects in the composite are treated the same way.
 */
public class Company implements Employee{

   private List<Employee> employees = new ArrayList<>();

    /**
     * This method prints details of all company employees.
     */
    @Override
    public void showEmployeeDetails() {
        for (Employee emp: employees) {
            emp.showEmployeeDetails();
        }
    }

    /**
     * This method adds a new Employee into the employees' list.
     * @param emp - the employee to be added
     */
    public void add(Employee emp) {
        this.employees.add(emp);
    }

    /**
     * This method removes an employee from the employees' list.
     * @param emp - the employee to be removed
     */
    public void remove(Employee emp) {
        this.employees.remove(emp);
    }
}

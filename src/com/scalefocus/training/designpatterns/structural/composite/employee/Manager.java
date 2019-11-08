package com.scalefocus.training.designpatterns.structural.composite.employee;

/**
 * @author Kristiyan SLavov
 *
 * A Leaf that is a building block for the composition and also implements the base component.
 * Defines the behaviour for the element in the composition.
 */
public class Manager implements Employee {

    private String name;

    private long empId;

    private String position;

    public Manager(String name, long empId, String position) {
        this.name = name;
        this.empId = empId;
        this.position = position;
    }

    @Override
    public void showEmployeeDetails() {
        System.out.println(empId + " " + name + " " + position);
    }
}

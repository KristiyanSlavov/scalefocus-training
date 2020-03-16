package com.scalefocus.training.designpatterns.structural.composite.employee;

/**
 * @author Kristiyan SLavov
 *
 * A Leaf that is a building block for the composition and also implements the base component.
 * Defines the behaviour for the element in the composition.
 */
public class Developer implements Employee{

    private String name;

    private long devId;

    private String department;

    public Developer(String name, long devId, String department) {
        this.name = name;
        this.devId = devId;
        this.department = department;
    }

    @Override
    public void showEmployeeDetails() {
        System.out.println(devId + " " + name + " " + department);
    }
}

package com.scalefocus.training.designpatterns.structural.composite.employee;

/**
 * @author Kristiyan SLavov
 *
 * A Base component which declares the interface for objects in the composition and for accessing
 * and managing its child components.It is used by the client who interact with the objects
 * in the compostion structure.
 */
public interface Employee {

    /**
     * This method shows the Employee's details.
     */
    void showEmployeeDetails();
}

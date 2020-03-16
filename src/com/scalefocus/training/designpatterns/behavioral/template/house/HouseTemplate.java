package com.scalefocus.training.designpatterns.behavioral.template.house;

/**
 * @author Kristiyan SLavov
 *
 * The Abstract Class. It contains the buildHouse method ("the template method")
 * which should be made final so that it cannot be overriden. This template method makes use of other
 * operations available in order to run the algorithm but is decoupled
 * for the actual implementation of these methods.
 * All or most of operations used by this template method are made abstract,
 * so their implementation is deferred to subclasses.
 */
public abstract class HouseTemplate {

    //final template method, so subclasses can't override it
    public final void buildHouse() {
        buildFoundation();
        buildPillars();
        buildWalls();
        buildWindows();
        System.out.println("The house is built.");
    }

    public abstract void buildWalls();
    public abstract void buildPillars();

    //Default implementation of buildWindows method
    private void buildWindows() {
        System.out.println("Building Glass Windows.");
    }

    //Default implementation of buildFoundation method
    private void buildFoundation() {
        System.out.println("Building foundation with cement, iron and sands.");
    }
}

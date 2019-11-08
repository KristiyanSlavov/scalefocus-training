package com.scalefocus.training.designpatterns.structural.bridge.vehicle;

/**
 * @author Kristiyan SLavov
 *
 * The concrete Implementation 2 - implements the Implementor by providing concrete implementation.
 */
public class Assemble implements Workshop {

    /**
     * Concrete implementation of work method that carries out assemble.
     */
    @Override
    public void work() {
        System.out.print(" and");
        System.out.println(" Assembled.");
    }
}

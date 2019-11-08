package com.scalefocus.training.designpatterns.structural.bridge.vehicle;

/**
 * @author Kristiyan SLavov
 *
 * The concrete Implementation 1 - implements the Implementor by providing concrete implementation.
 */
public class Produce implements Workshop {

    /**
     * Concrete implementation of work method that carries out production.
     */
    @Override
    public void work() {
        System.out.printf("Produced");
    }
}

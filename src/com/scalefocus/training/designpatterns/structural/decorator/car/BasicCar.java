package com.scalefocus.training.designpatterns.structural.decorator.car;

/**
 * @author Kristiyan SLavov
 *
 * The Component Implementation - the basic implementation of the component interface.
 */
public class BasicCar implements Car {

    /**
     * Concrete implementation of assemble method that carries out assemble a basic car.
     */
    @Override
    public void assemble() {
        System.out.println("Basic Car.");
    }
}

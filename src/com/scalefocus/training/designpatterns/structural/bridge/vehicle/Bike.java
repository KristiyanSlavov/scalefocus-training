package com.scalefocus.training.designpatterns.structural.bridge.vehicle;

/**
 * @author Kristiyan SLavov
 *
 * The Refined Abstraction 2 - extends the abstraction (child of "the abstraction")
 * and takes the details one level below. Hides the elements/implementation from the implementors.
 */
public class Bike extends Vehicle {

    public Bike(Workshop workShop1, Workshop workShop2) {
        super(workShop1, workShop2);
    }

    /**
     * Concrete implementation of manufacture method that carries out the manufacture of a bike
     */
    @Override
    public void manufacture() {
        System.out.print("Bike");
        workShop1.work();
        workShop2.work();
    }
}

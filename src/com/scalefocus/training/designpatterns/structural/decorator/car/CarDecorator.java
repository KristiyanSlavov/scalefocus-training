package com.scalefocus.training.designpatterns.structural.decorator.car;

/**
 * The Base Decorator. This class implements the Component Interface (Car interface)
 * and it has a HAS-A relationship with the Component Interface.
 * The component variable (carDecorator) should be accessible to the child decorator
 * class/es, so we will make it protected.
 *
 * @author Kristiyan SLavov
 */
public abstract class CarDecorator implements Car {

    protected Car decorator;

    public CarDecorator(Car car) {
        this.decorator = car;
    }

    /**
     * Implementation of getDescription method that returns the Basic Car class getDescription method.
     */
    @Override
    public void getDescription() {
        this.decorator.getDescription();
    }

    /**
     * Implementation of driveForward method that returns the Basic Car class driveForward method.
     */
    @Override
    public void driveForward() {
        this.decorator.driveForward();
}

    /**
     * This is the new functionality of the Basic Car class.
     * It sets a driver to the car.
     *
     * @param driver - the driver of the car
     */
    public abstract void setDriver(String driver);
}

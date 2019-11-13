package com.scalefocus.training.designpatterns.structural.decorator.car;

/**
 * The Concrete Decorator. This class extends the Base Decorator functionality
 * and modify the Component behavior accordingly. It also added a new functionality (setDriver).
 *
 * @author Kristiyan SLavov
 */
public class AssignDriverDecorator extends CarDecorator{

    private String driver;

    public AssignDriverDecorator(Car car) {
        super(car);
    }

    /**
     * Concrete implementation of getDescription method that returns an information about
     * the Basic Car and a information about the new driver of the car.
     */
    @Override
    public void getDescription() {
        decorator.getDescription();
        System.out.println("With a new driver: " + this.driver);
    }

    /**
     * Concrete implementation of driveForward method that returns an information about
     * the Basic Car and an information about the new driver of the car.
     */
    @Override
    public void driveForward() {
        decorator.getDescription();
        System.out.println("With a new driver on board: " + this.driver);
    }

    /**
     * This method assigns a driver to the car and return information about the new driver.
     *
     * @param driver - the driver of the car
     */
    @Override
    public void setDriver(String driver) {
        this.driver = driver;
        System.out.println("The car is with a new driver: " + this.driver);
    }
}

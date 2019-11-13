package com.scalefocus.training.designpatterns.structural.decorator.car;

/**
 * The Component Implementation / The Concrete Component.
 * It implements The Component Interface' (Car interface) method/s.
 *
 * @author Kristiyan SLavov
 */
public class BasicCar implements Car{

    /**
     * Concrete implementation of getDescription method, that returns information for the basic car.
     */
    @Override
    public void getDescription() {
        System.out.println("This is a Basic Car.");
    }

    /**
     * Concrete implementation of driveForward method, that returns information that
     * the basic car is driving forward.
     */
    @Override
    public void driveForward() {
        System.out.println("The Basic Car is driving forward.");
    }
}

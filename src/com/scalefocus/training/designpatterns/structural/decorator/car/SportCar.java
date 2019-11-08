package com.scalefocus.training.designpatterns.structural.decorator.car;

/**
 * @author Kristiyan SLavov
 *
 * The Concrete Decorator 1 - it extends the base decorator's functionality and modify the component behavior.
 */
public class SportCar extends CarDecorator {

    public SportCar(Car c) {
        super(c);
    }

    /**
     * Concrete implementation of assemble method that adds a features of a sport car.
     */
    public void assemble() {
        super.assemble();
        System.out.print(" Adding features of Sport Car.");
    }
}

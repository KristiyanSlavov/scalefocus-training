package com.scalefocus.training.designpatterns.structural.decorator.car;

/**
 * @author Kristiyan SLavov
 *
 * The Concrete Decorator 2 - it extends the base decorator's functionality and modify the component behavior.
 */
public class LuxuryCar extends CarDecorator {

    public LuxuryCar(Car c) {
        super(c);
    }

    public void assemble() {
        super.assemble();
        System.out.print(" Adding features of Luxury Car.");
    }
}

package com.scalefocus.training.designpatterns.structural.decorator.car;

/**
 * @author Kristiyan SLavov
 *
 * The Decorator - this class implements the component interface and it has a HAS-A relationship
 * with it. The component variable should be accessible to the child decorator classes, so
 * we will make this variable protected.
 */
public class CarDecorator implements Car {

    protected Car car;

    public CarDecorator(Car c) {
        this.car = c;
    }

    @Override
    public void assemble() {
        this.car.assemble();;
    }
}

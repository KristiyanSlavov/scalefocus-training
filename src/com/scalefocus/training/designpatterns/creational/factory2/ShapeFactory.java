package com.scalefocus.training.designpatterns.creational.factory2;

/**
 * @author Kristiyan SLavov
 */
public class ShapeFactory {

    /**
     * This method uses a Factory Method Design Pattern to return an instance based on a given type.
     * This pattern takes out the responsibility of instantiation of a class
     * from client program to the factory class (StaticComputerFactory).
     *
     * @param type - the type which will determine what instance will be returned (Circle/Rectangle/Square)
     * @return - new instance of type Shape
     */
    public static Shape getShape(String type) {
        if ("Circle".equalsIgnoreCase(type)) {
            return new Circle();

        } else if ("Rectangle".equalsIgnoreCase(type)) {
            return new Rectangle();

        } else if ("Square".equalsIgnoreCase(type)) {
            return new Square();
        }
        return null;
    }
}

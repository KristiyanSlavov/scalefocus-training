package com.scalefocus.training.designpatterns.structural.bridge.shape;

/**
 * @author Kristiyan SLavov
 */
public class Circle extends Shape {

    public Circle(Color c) {
        super(c);
    }

    @Override
    public void applyColor() {
        System.out.print("Circle filled with ");
        color.applyColor();
    }
}

package com.scalefocus.training.designpatterns.structural.bridge.shape;

/**
 * @author Kristiyan SLavov
 *
 * The Refined Abstraction 2 - extends the abstraction (child of "the abstraction")
 * and takes the details one level below. Hides the elements/implementation from the implementors.
 */
public class Triangle extends Shape{

    public Triangle(Color c) {
        super(c);
    }

    /**
     * Concrete implementation of applyColor method that fills a triangle with a specific color.
     */
    @Override
    public void applyColor() {
        System.out.print("Triangle filled with color ");
        color.applyColor();
    }
}

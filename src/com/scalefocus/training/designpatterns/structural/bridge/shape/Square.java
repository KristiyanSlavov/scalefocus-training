package com.scalefocus.training.designpatterns.structural.bridge.shape;

/**
 * @author Kristiyan SLavov
 *
 * The Refined Abstraction 1 - extends the abstraction (child of "the abstraction")
 * and takes the details one level below. Hides the elements/implementation from the implementors.
 */
public class Square extends Shape {

    public Square(Color c) {
        super(c);
    }

    /**
     * Concrete implementation of applyColor method that fills a square with a specific color.
     */
    @Override
    public void applyColor() {
        System.out.print("Square filled with color ");
        color.applyColor();
    }
}

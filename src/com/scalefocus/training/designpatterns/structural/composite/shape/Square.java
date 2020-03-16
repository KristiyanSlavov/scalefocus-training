package com.scalefocus.training.designpatterns.structural.composite.shape;

/**
 * @author Kristiyan SLavov
 *
 * A Leaf that is a building block for the composition and also implements the base component.
 * Defines the behaviour for the element in the composition.
 */
public class Square implements Shape {

    @Override
    public void draw(String fillColor) {
        System.out.println("Drawing Square with color " + fillColor);
    }
}

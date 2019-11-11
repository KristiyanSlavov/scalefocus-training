package com.scalefocus.training.designpatterns.structural.bridge.shape;

/**
 * @author Kristiyan SLavov
 *
 * The concrete Implementation 3 - implements the Implementor by providing concrete implementation.
 */
public class GreenColor extends Color {

    /**
     * Concrete implementation of applyColor method that applies a green color.
     */
    @Override
    public void applyColor() {
        System.out.println("green.");
    }
}

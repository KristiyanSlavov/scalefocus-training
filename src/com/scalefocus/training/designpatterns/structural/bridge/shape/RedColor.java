package com.scalefocus.training.designpatterns.structural.bridge.shape;

/**
 * @author Kristiyan SLavov
 *
 * The concrete Implementation 1 - implements the Implementor by providing concrete implementation.
 */
public class RedColor implements Color{

    /**
     * Concrete implementation of applyColor method that applies a blue color.
     */
    @Override
    public void applyColor() {
        System.out.println("red.");
    }
}

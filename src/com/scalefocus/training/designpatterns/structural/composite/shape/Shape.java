package com.scalefocus.training.designpatterns.structural.composite.shape;

/**
 * @author Kristiyan SLavov
 *
 * A Base component which declares the interface for objects in the composition and for accessing
 * and managing its child components.It is used by the client who interact with the objects
 * in the compostion structure.
 */
public interface Shape {

    /**
     * This method draw a Shape with a specified color.
     *
     * @param fillColor - the color with which a Shape will be drawn.
     */
    void draw(String fillColor);
}

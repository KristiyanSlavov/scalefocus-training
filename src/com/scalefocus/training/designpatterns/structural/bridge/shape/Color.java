package com.scalefocus.training.designpatterns.structural.bridge.shape;

/**
 * @author Kristiyan SLavov
 *
 * The implementor - it defines the interface for implementation classes.
 * This interface does not need to correspond directrly to the abstraction interface and
 * can be very different.
 * The implementor is an interface or abstract class.
 */
public interface Color {

    void applyColor();
}

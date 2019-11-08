package com.scalefocus.training.designpatterns.structural.bridge.shape;

/**
 * @author Kristiyan SLavov
 *
 * The abstraction - core of the bridge design pattern and it defines the crux.
 * Contains a reference/references to the implementor.
 * The abstraction can be an interface or abstract class.
 */
public abstract class Shape {

    protected Color color;

    public Shape(Color c) {
        this.color = c;
    }

    abstract public void applyColor();
}

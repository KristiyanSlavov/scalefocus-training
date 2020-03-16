package com.scalefocus.training.designpatterns.structural.composite.shape;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kristiyan SLavov
 * A Composite that consists of leaf elements and also implements the base component's operation/s.
 * All objects in the composite are treated the same way.
 */
public class DrawingComposite implements Shape {

    private List<Shape> shapes = new ArrayList<>();

    public List<Shape> getShapes() {
        return shapes;
    }

    /**
     * This method draws all the shapes from the shapes' list with the specified color.
     *
     * @param fillColor - the color with which all the shapes will be drawn.
     */
    @Override
    public void draw(String fillColor) {
        for (Shape shape: shapes) {
            shape.draw(fillColor);
        }
    }

    /**
     * This method add a new shape into the shapes' list.
     *
     * @param sh - the shape to be added
     */
    public void add(Shape sh) {
        this.shapes.add(sh);
    }

    /**
     * This method removes a shape from the shapes' list.
     *
     * @param sh - the shape to be removed
     */
    public void remove(Shape sh) {
        this.shapes.remove(sh);
    }

    /**
     * This method clear the shapes' list.
     */
    public void clear() {
        this.shapes.clear();
    }
}

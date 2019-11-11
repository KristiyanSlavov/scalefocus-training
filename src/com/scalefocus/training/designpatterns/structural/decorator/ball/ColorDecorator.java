package com.scalefocus.training.designpatterns.structural.decorator.ball;

/**
 * @author Kristiyan SLavov
 *
 * The Decorator - this class implements the component interface and it has a HAS-A relationship
 * with it. The component variable should be accessible to the child decorator classes, so
 * we will make this variable protected.
 */
public abstract class ColorDecorator implements Ball {

    protected Ball ball;

    public ColorDecorator(Ball ball) {
        this.ball = ball;
    }

    /**
     * This method calls component variable's (ball) color method.
     */
    @Override
    public void color() {
        this.ball.color();
    }
}

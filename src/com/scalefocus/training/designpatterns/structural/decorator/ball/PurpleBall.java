package com.scalefocus.training.designpatterns.structural.decorator.ball;

/**
 * @author Kristiyan SLavov
 *
 * The Concrete Decorator 2 - it extends the base decorator's functionality and modify the component behavior.
 */
public class PurpleBall extends ColorDecorator {

    public PurpleBall(Ball ball) {
        super(ball);
    }

    /**
     * Concrete implementation of the color method that makes the basic ball to be with purple color.
     */
    public void color(){
        ball.color();
        System.out.println(" purple color.");
    }
}

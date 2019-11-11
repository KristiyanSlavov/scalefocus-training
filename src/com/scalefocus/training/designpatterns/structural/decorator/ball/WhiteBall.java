package com.scalefocus.training.designpatterns.structural.decorator.ball;

/**
 * @author Kristiyan SLavov
 *
 * The Concrete Decorator 1 - it extends the base decorator's functionality and modify the component behavior.
 */
public class WhiteBall extends ColorDecorator {

    public WhiteBall(Ball ball) {
        super(ball);
    }

    /**
     * Concrete implementation of the color method that makes the basic ball to be with white color.
     */
    public void color(){
        ball.color();
        System.out.println(" white color.");
    }
}

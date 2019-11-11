package com.scalefocus.training.designpatterns.structural.decorator.ball;

/**
 * @author Kristiyan SLavov
 *
 * The Component Implementation - the basic implementation of the component interface.
 */
public class BasicBall implements Ball {

    /**
     * Implementation of color method that shows basic ball's color.
     */
    @Override
    public void color() {
        System.out.print("Basic ball with ");
    }
}

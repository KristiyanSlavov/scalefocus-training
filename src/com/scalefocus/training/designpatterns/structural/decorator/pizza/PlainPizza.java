package com.scalefocus.training.designpatterns.structural.decorator.pizza;

/**
 * @author Kristiyan SLavov
 */
public class PlainPizza implements Pizza{

    @Override
    public String getDescription() {
        return "Thin Dough";
    }

    @Override
    public double getCost() {
        return 4.00;
    }
}

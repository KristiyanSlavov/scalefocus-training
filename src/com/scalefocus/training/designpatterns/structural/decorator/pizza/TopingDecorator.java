package com.scalefocus.training.designpatterns.structural.decorator.pizza;

/**
 * @author Kristiyan SLavov
 */
public abstract class TopingDecorator implements Pizza{

    protected Pizza tempPizza;

    public TopingDecorator(Pizza newPizza) {
        this.tempPizza = newPizza;
    }

    public String getDescription(){
        return tempPizza.getDescription();
    }

    public double getCost() {
        return tempPizza.getCost();
    }
}

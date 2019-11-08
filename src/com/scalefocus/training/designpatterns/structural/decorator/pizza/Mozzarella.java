package com.scalefocus.training.designpatterns.structural.decorator.pizza;

/**
 * @author Kristiyan SLavov
 */
public class Mozzarella extends TopingDecorator{

    public Mozzarella(Pizza newPizza) {
        super(newPizza);
    }

    public String getDescription(){
        return tempPizza.getDescription() + " ,Mozzarella.";
    }

    public double getCost() {
        return tempPizza.getCost() + 1.50;
    }
}

package com.scalefocus.training.designpatterns.structural.decorator.pizza;

/**
 * @author Kristiyan SLavov
 */
public class TomatoSauce extends ToppingDecorator {

    public TomatoSauce(Pizza newPizza) {
        super(newPizza);
    }

    public String getDescription() {
        return tempPizza.getDescription() + " ,TomatoSauce.";
    }

    public double getCost() {
        return tempPizza.getCost() + .70;
    }
}




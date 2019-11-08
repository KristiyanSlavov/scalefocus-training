package com.scalefocus.training;

import com.scalefocus.training.designpatterns.structural.decorator.pizza.Mozzarella;
import com.scalefocus.training.designpatterns.structural.decorator.pizza.Pizza;
import com.scalefocus.training.designpatterns.structural.decorator.pizza.PlainPizza;
import com.scalefocus.training.designpatterns.structural.decorator.pizza.TomatoSauce;

public class TrainingApp {

    public static void main(String[] args) {
        Pizza basicPizza = new TomatoSauce(new Mozzarella(new PlainPizza()));
        Pizza basic2 = new Mozzarella(new PlainPizza());
        System.out.println(basic2.getDescription());
    }
}

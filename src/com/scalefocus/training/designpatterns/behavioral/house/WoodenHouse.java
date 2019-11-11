package com.scalefocus.training.designpatterns.behavioral.house;

/**
 * @author Kristiyan SLavov
 *
 * The Concrete Class 2. It implements all the operations required by the templateMethod
 * that were defined as abstract in the parent class. There can be many different ConcreteClasses.
 */
public class WoodenHouse extends HouseTemplate {

    @Override
    public void buildWalls() {
        System.out.println("Building Wooden Walls.");
    }

    @Override
    public void buildPillars() {
        System.out.println("Building Pillars with Wood coating.");
    }
}

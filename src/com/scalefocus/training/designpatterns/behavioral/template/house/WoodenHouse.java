package com.scalefocus.training.designpatterns.behavioral.template.house;

/**
 * @author Kristiyan SLavov
 *
 * The Concrete Class 2. It implements all the operations required by the templateMethod
 * that were defined as abstract in the parent class. There can be many different ConcreteClasses.
 */
public class WoodenHouse extends HouseTemplate {

    /**
     * Concrete implementation of buildWalls method which returns information that
     * the house walls are made of wood.
     */
    @Override
    public void buildWalls() {
        System.out.println("Building Wooden Walls.");
    }

    /**
     * Concrete implementation of buildPillars method which returns information that
     * the house walls are wood of wood.
     */
    @Override
    public void buildPillars() {
        System.out.println("Building Pillars with Wood coating.");
    }
}

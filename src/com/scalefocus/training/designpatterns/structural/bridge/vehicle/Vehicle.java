package com.scalefocus.training.designpatterns.structural.bridge.vehicle;

/**
 * @author Kristiyan SLavov
 * <p>
 * The abstraction - core of the bridge design pattern and it defines the crux.
 * Contains a reference/references to the implementor.
 * The abstraction can be an interface or abstract class.
 */
public abstract class Vehicle {

    protected Workshop workShop1;

    protected Workshop workShop2;

    public Vehicle(Workshop workShop1, Workshop workShop2) {
        this.workShop1 = workShop1;
        this.workShop2 = workShop2;
    }

    public abstract void manufacture();
}

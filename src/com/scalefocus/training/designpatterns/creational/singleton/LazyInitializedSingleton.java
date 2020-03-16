package com.scalefocus.training.designpatterns.creational.singleton;

/**
 * @author Kristiyan SLavov
 */
public class LazyInitializedSingleton {

    private static LazyInitializedSingleton instance;

    private LazyInitializedSingleton() {}

    /**
     * This method creates the instance of the LazyInitializedSingleton class
     * in the global access method.
     *
     * @return - the instance of the class
     */
    public static LazyInitializedSingleton getInstance() {
        if(instance == null) {
            instance = new LazyInitializedSingleton();
        }
        return instance;
    }
}

package com.scalefocus.training.designpatterns.creational.singleton;

/**
 * @author Kristiyan SLavov
 */
public class StaticBlockSingleton {

    private static StaticBlockSingleton instance;

    private StaticBlockSingleton() {}

    /**
     * Instance of StaticBlockSingleton class is created at the time of class loading
     * Static block initialization for exception handling
     */
    static {
        try{
            instance = new StaticBlockSingleton();
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred in creating singleton instance");
        }
    }

    /**
     * @return - the instance of the class
     */
    public static StaticBlockSingleton getInstance() {
        return instance;
    }
}

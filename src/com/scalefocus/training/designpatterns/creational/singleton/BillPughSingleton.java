package com.scalefocus.training.designpatterns.creational.singleton;

/**
 * @author Kristiyan SLavov
 */
public class BillPughSingleton {

    private BillPughSingleton() {}

    /**
     * This private inner class contains the instance of the class.
     * It is not loaded into memory until someone class the getInstance() method.
     */
    private static class SingletonHelper{
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    /**
     * This method return the instance of the class
     * with the help of the private inner class SingletonHelper.
     *
     * @return - the instance of the class
     */
    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}

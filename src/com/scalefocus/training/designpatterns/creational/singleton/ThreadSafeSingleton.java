package com.scalefocus.training.designpatterns.creational.singleton;

/**
 * @author Kristiyan SLavov
 */
public class ThreadSafeSingleton {

    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {}

    /**
     * This method creates a thread-safe instance of the class.
     * But it reduces the performance because of the cost associated with the synchronized method.
     *
     * @return - the instance of the class
     */
    public static synchronized ThreadSafeSingleton getInstance() {
        if(instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }

    /**
     * This method used "double checked locking" for creating a instance of the class.
     * In this approach, the synchronized block is used inside the if condition
     * with an additional check to ensure that only one instance of a class is created.
     * It has better performance.
     *
     * @return
     */
    public static ThreadSafeSingleton getInstanceUsingDoubleLocking() {
        if(instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if(instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
}

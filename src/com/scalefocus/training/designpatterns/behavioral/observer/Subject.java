package com.scalefocus.training.designpatterns.behavioral.observer;

/**
 * The Base Subject interface (Publisher).
 * It defines the contract methods to be implemented by any concrete subject.
 * These contract methods are add a new observer, delete observer and notify (+update)
 * all register observers.
 *
 * @author Kristiyan SLavov
 */
public interface Subject {

    void register(Observer newObserver);

    void unregister(Observer observer);

    void notifyObservers();
}

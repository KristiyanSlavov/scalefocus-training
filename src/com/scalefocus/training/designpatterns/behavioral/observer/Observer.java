package com.scalefocus.training.designpatterns.behavioral.observer;

/**
 * The Base Observer interface (Subscriber).
 * It has a update method that will be called when the Subject changes.
 *
 * @author Kristiyan SLavov
 */
public interface Observer {

    void update();
}

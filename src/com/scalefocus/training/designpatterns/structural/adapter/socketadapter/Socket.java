package com.scalefocus.training.designpatterns.structural.adapter.socketadapter;

/**
 * @author Kristiyan SLavov
 * A class that produce a constant volts of 120V
 */
public class Socket {

    /**
     * @return - a volt object with 120V
     */
    public Volt getVolt() {
        return new Volt(120);
    }
}

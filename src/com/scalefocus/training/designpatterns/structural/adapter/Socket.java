package com.scalefocus.training.designpatterns.structural.adapter;

/**
 * @author Kristiyan SLavov
 */
public class Socket {

    public Volt getVolt() {
        return new Volt(120);
    }
}

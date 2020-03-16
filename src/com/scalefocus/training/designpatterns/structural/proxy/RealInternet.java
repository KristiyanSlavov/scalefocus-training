package com.scalefocus.training.designpatterns.structural.proxy;

/**
 * @author Kristiyan SLavov
 */
public class RealInternet implements Internet {

    @Override
    public void connectTo(String serverHost) {
        System.out.println("Connected to " + serverHost);
    }
}

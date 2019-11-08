package com.scalefocus.training.designpatterns.structural.proxy;

/**
 * @author Kristiyan SLavov
 */
public class RealInternet implements Internet {

    @Override
    public void connectTo(String serverhost) {
        System.out.println("Connected to " + serverhost);
    }
}

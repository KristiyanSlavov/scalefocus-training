package com.scalefocus.training.designpatterns.structural.adapter.socketadapter;

/**
 * @author Kristiyan SLavov
 *
 * A class that is a measure of volts.
 */
public class Volt {

    private int volts;

    public Volt(int volts) {
        this.volts = volts;
    }

    public int getVolts() {
        return volts;
    }

    public void setVolts(int volts) {
        this.volts = volts;
    }
}

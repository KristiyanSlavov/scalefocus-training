package com.scalefocus.training.designpatterns.structural.adapter;

/**
 * @author Kristiyan SLavov
 */
public interface SocketAdapter {

    Volt get120Volts();

    Volt get12Volts();

    Volt get3Volts();
}

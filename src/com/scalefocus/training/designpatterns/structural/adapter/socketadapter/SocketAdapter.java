package com.scalefocus.training.designpatterns.structural.adapter.socketadapter;

/**
 * @author Kristiyan SLavov
 *
 * Adapter interface that produces 3 volts, 12 volts and default 120 volts
 */
public interface SocketAdapter {

    /**
     * @return - a volt object with default 120V
     */
    Volt get120Volts();

    /**
     * @return - a volt object with 12V
     */
    Volt get12Volts();

    /**
     * @return - a volt object with 3V
     */
    Volt get3Volts();
}

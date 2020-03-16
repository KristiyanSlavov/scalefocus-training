package com.scalefocus.training.designpatterns.structural.adapter.socketadapter;

/**
 * @author Kristiyan SLavov
 *
 * The adapter pattern that converts the interface of a class into another interface clients expect.
 * It lets classes wotk together that couldn't otherwise because of incompatible interfaces.
 */
public class Adapter implements SocketAdapter {

    private Socket socket = new Socket();

    /**
     * @return - a volt object with default 120V
     */
    @Override
    public Volt get120Volts() {
        return socket.getVolt();
    }

    /**
     * @return - a volt object with 12V
     */
    @Override
    public Volt get12Volts() {
        Volt v = socket.getVolt();
        return convertVolt(v, 10);
    }

    /**
     * @return - a vault object with 3V
     */
    @Override
    public Volt get3Volts() {
        Volt v = socket.getVolt();
        return convertVolt(v, 40);
    }

    /**
     * This method converts default 120V to another volts
     *
     * @param v - the default 120V
     * @param i - the parameter by which the default 120V will be divided to obtain the new volts.
     * @return - a volt object with the new volts
     */
    private Volt convertVolt(Volt v, int i) {
        return new Volt(v.getVolts() / i);
    }
}

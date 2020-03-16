package com.scalefocus.training.designpatterns.creational.builder;

/**
 * @author Kristiyan SLavov
 */
public class Computer {

    //required params
    private String hdd;

    private String ram;

    //optional params
    private boolean isGraphicsCardEnabled;

    private boolean isBluetoothEnabled;

    /**
     * The constructor is private so the only way to create an instance
     * of this class is trough the ComputerBuilder inner class.
     *
     * @param builder - builder that returns an instance of type Computer
     */
    private Computer(ComputerBuilder builder) {
        this.hdd = builder.hdd;
        this.ram = builder.ram;
        this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
    }

    /**
     * @return - the computer's hard disk drive attribute
     */
    public String getHdd() {
        return hdd;
    }

    /**
     * @return - the computer's ram memory attribute
     */
    public String getRam() {
        return ram;
    }

    /**
     * @return - true if computer's graphics card is enabled
     */
    public boolean isGraphicsCardEnabled() {
        return isGraphicsCardEnabled;
    }

    /**
     * @return - true if computer's bluetooth is enabled
     */
    public boolean isBluetoothEnabled() {
        return isBluetoothEnabled;
    }

    /**
     * The inner class copies all the outer's class attributes (required and optional)
     * and create an instance of the outer class.
     */
    public static class ComputerBuilder {

        //required params
        private String hdd;

        private String ram;

        //optional params
        private boolean isGraphicsCardEnabled;

        private boolean isBluetoothEnabled;

        /**
         * Constructor for required params
         *
         * @param hdd - the hard disk drive of the computer
         * @param ram - the ram memory of the computer
         */
        public ComputerBuilder(String hdd, String ram) {
            this.hdd = hdd;
            this.ram = ram;
        }

        /**
         * This method sets computer's graphic card.
         *
         * @param isGraphicsCardEnabled - true if the graphic card is enabled or false if it's not
         * @return - the builder object
         */
        public ComputerBuilder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
            this.isGraphicsCardEnabled = isGraphicsCardEnabled;
            return this;
        }

        /**
         * This method sets computer's bluetooth.
         *
         * @param isBluetoothEnabled - true if computer's bluetooth is enabled or false if it's not
         * @return - the builder object
         */
        public ComputerBuilder setBluetoothEnabled(boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }

        /**
         * This method returns an instance of type Computer and it is the only way
         * to create an instance of this type.
         *
         * @return - an instance of type Computer
         */
        public Computer build(){
            return new Computer(this);
        }
    }
}

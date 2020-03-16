package com.scalefocus.training.designpatterns.creational.factory;

/**
 * @author Kristiyan SLavov
 */
public class StaticComputerFactory {

    /**
     * This method uses a Factory Method Design Pattern to return an instance based on a given type.
     * This pattern takes out the responsibility of instantiation of a class
     * from client program to the factory class (StaticComputerFactory).
     *
     * @param type - the type which will determine what instance will be returned (PC/Server)
     * @param ram - the ram of the Computer's instance
     * @param hdd - the hdd of the Computer's instance
     * @param cpu - the cpu of the Computer's instance
     * @return - new instance of type Computer
     */
    public static Computer getComputer(String type, String ram, String hdd, String cpu) {
        if ("PC".equalsIgnoreCase(type)) {
            return new PC(ram, hdd, cpu);
        } else if("Server".equalsIgnoreCase(type)){
            return new Server(ram, hdd, cpu);
        }
        return null;
    }

}

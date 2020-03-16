package com.scalefocus.training.designpatterns.behavioral.command.remotecontroller;

/**
 * @author Kristiyan SLavov
 */
public class Stereo {

    public void on() {
        System.out.println("The stereo is on.");
    }

    public void off() {
        System.out.println("The stereo is off.");
    }

    public void setCD() {
        System.out.println("The stereo is set for CD input.");
    }

    public void setRadio() {
        System.out.println("The stereo is set for Radio.");
    }

    public void setVolume(int volume) {
        System.out.println("The stereo volume set to " + volume + " .");
    }
}

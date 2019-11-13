package com.scalefocus.training.designpatterns.behavioral.command.remotecontroller;

/**
 * @author Kristiyan SLavov
 */
public class LightOffCommand implements Command {

    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }
}

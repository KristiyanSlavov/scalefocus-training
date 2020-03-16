package com.scalefocus.training.designpatterns.behavioral.command.remotecontroller;

/**
 * @author Kristiyan SLavov
 */
public class LightOnCommand implements Command {

    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}

package com.scalefocus.training.designpatterns.behavioral.command.remotecontroller;

/**
 * @author Kristiyan SLavov
 */
public class RemoteControl {

    private Command slot;

    public void setCommand(Command command) {
        slot = command;
    }

    public void buttonWasPressed() {
        slot.execute();
    }
}

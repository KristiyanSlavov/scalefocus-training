package com.scalefocus.training.designpatterns.behavioral.command.filesystem;

/**
 * @author Kristiyan SLavov
 */
public class FileInvoker {

    private Command command;

    public FileInvoker(Command command) {
        this.command = command;
    }

    public void invoke() {
        this.command.execute();
    }
}

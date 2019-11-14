package com.scalefocus.training.designpatterns.behavioral.command.filesystem;

/**
 * The Command Pattern Invoker Class.
 * This class encapsulates the Command and passes the request to the
 * command object to process it.
 * It provides an invoke method that calls the given command object the execute method.
 *
 * @author Kristiyan SLavov
 */
public class FileInvoker {

    private Command command;

    public FileInvoker(Command command) {
        this.command = command;
    }

    /**
     * This method calls the command object the execute method.
     */
    public void invoke() {
        this.command.execute();
    }
}

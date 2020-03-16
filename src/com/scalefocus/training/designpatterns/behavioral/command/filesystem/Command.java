package com.scalefocus.training.designpatterns.behavioral.command.filesystem;

/**
 * The Base Command - It provides a method (execute) that will be implemented in a different way
 * by the classes which will implement this interface..
 *
 * @author Kristiyan SLavov
 */
public interface Command {

    void execute();
}

package com.scalefocus.training.designpatterns.behavioral.command.filesystem;

/**
 * @author Kristiyan SLavov
 *
 * The FileSystemReceiver interface - defines the contract for the implementation classes.
 * For simplicity, there are two flavors of receiver classes to work with Unix and Windows systems.
 */
public interface FileSystemReceiver {

    void openFile();

    void writeFile();

    void closeFile();
}

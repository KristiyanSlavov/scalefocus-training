package com.scalefocus.training.designpatterns.behavioral.command.filesystem;

/**
 * @author Kristiyan SLavov
 *
 * The receiver class 1: to work with a Unix OS.
 */
public class UnixFileSystemReceiver implements FileSystemReceiver {

    /**
     * Concrete implementation of openFile method that opens a file in UNIX OS.
     */
    @Override
    public void openFile() {
        System.out.println("Opening file in UNIX OS.");
    }

    /**
     * Concrete implementation of writeFile method that writes a file in UNIX OS.
     */
    @Override
    public void writeFile() {
        System.out.println("Writing file in UNIX OS.");
    }

    /**
     * Concrete implementation of closeFile method that closes a file in UNIX OS.
     */
    @Override
    public void closeFile() {
        System.out.println("Closing file in UNIX OS.");
    }
}

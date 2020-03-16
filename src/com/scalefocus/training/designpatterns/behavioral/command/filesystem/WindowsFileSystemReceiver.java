package com.scalefocus.training.designpatterns.behavioral.command.filesystem;

/**
 * @author Kristiyan SLavov
 * <p>
 * The receiver class 2: to work with a Windows OS.
 */
public class WindowsFileSystemReceiver implements FileSystemReceiver {

    /**
     * Concrete implementation of openFile method that opens a file in Windows OS.
     */
    @Override
    public void openFile() {
        System.out.println("Opening file in Windows OS.");
    }

    /**
     * Concrete implementation of writeFile method that writes a file in Windows OS.
     */
    @Override
    public void writeFile() {
        System.out.println("Writing file in Windows OS.");
    }

    /**
     * Concrete implementation of closeFile method that closes a file in Windows OS.
     */
    @Override
    public void closeFile() {
        System.out.println("Closing file in Windows OS.");
    }
}

package com.scalefocus.training.designpatterns.behavioral.command.filesystem;

/**
 * The Command Implementation 1.
 * This class implements Command interface and provides a different implementation
 * of the execute method. It contains a FileSystemReceiver reference (Receiver) and will forward
 * the request to the appropriate method of FileSystemReceiver (Receiver), in this case, openFile method.
 *
 * @author Kristiyan SLavov
 */
public class OpenFileCommand implements Command {

    private FileSystemReceiver fileSystem;

    public OpenFileCommand(FileSystemReceiver fileSystem) {
        this.fileSystem = fileSystem;
    }

    /**
     * Concrete implementation of execute method that calls the fileSystem's openFile method.
     */
    @Override
    public void execute() {
        this.fileSystem.openFile();
    }
}

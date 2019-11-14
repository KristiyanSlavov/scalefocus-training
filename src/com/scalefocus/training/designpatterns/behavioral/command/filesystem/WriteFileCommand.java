package com.scalefocus.training.designpatterns.behavioral.command.filesystem;

/**
 * The Command Implementation 3.
 * This class implements Command interface and provides a different implementation
 * of the execute method. It contains a FileSystemReceiver reference (Receiver) and will forward
 * the request to the appropriate method of FileSystemReceiver (Receiver), in this case, writeFile method.
 *
 * @author Kristiyan SLavov
 */
public class WriteFileCommand implements Command {

    private FileSystemReceiver fileSystem;

    public WriteFileCommand(FileSystemReceiver fileSystem) {
        this.fileSystem = fileSystem;
    }

    /**
     * Concrete implementation of execute method that calls the fileSystem's closeFile method.
     */
    @Override
    public void execute() {
        this.fileSystem.writeFile();
    }
}

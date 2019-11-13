package com.scalefocus.training.designpatterns.behavioral.command.filesystem;

/**
 * @author Kristiyan SLavov
 */
public class WriteFileCommand implements Command {

    private FileSystemReceiver fileSystem;

    public WriteFileCommand(FileSystemReceiver fileSystem) {
        this.fileSystem = fileSystem;
    }

    @Override
    public void execute() {
        this.fileSystem.writeFile();
    }
}

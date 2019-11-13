package com.scalefocus.training.designpatterns.behavioral.command.filesystem;

/**
 * @author Kristiyan SLavov
 */
public class OpenFileCommand implements Command {

    private FileSystemReceiver fileSystem;

    public OpenFileCommand(FileSystemReceiver fileSystem) {
        this.fileSystem = fileSystem;
    }

    @Override
    public void execute() {
        this.fileSystem.openFile();
    }
}

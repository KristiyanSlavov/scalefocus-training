package com.scalefocus.training;

import com.scalefocus.training.designpatterns.behavioral.command.filesystem.Command;
import com.scalefocus.training.designpatterns.behavioral.command.filesystem.FileInvoker;
import com.scalefocus.training.designpatterns.behavioral.command.filesystem.FileSystemReceiver;
import com.scalefocus.training.designpatterns.behavioral.command.filesystem.OpenFileCommand;
import com.scalefocus.training.designpatterns.behavioral.command.filesystem.WindowsFileSystemReceiver;

public class TrainingApp {

    public static void main(String[] args) {
        FileSystemReceiver windowsSystem = new WindowsFileSystemReceiver();
        Command openFil = new OpenFileCommand(windowsSystem);
        FileInvoker invoker = new FileInvoker(openFil);
        invoker.invoke();
    }
}
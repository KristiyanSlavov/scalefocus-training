package com.scalefocus.training.designpatterns.behavioral.command.remotecontroller;

/**
 * @author Kristiyan SLavov
 */
public class StereoOffCommand implements Command {

    private Stereo stereo;

    public StereoOffCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.off();
    }
}

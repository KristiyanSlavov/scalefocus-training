package com.scalefocus.training;

import com.scalefocus.training.designpatterns.structural.adapter.Adapter;
import com.scalefocus.training.designpatterns.structural.adapter.SocketAdapter;
import com.scalefocus.training.designpatterns.structural.adapter.Volt;

public class TrainingApp {

    public static void main(String[] args) {
        SocketAdapter socketAdapter = new Adapter();
        Volt v3 = socketAdapter.get3Volts();
        Volt v12 = socketAdapter.get12Volts();
        Volt v120 = socketAdapter.get120Volts();

    }
}

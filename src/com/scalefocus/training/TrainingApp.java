package com.scalefocus.training;

import com.scalefocus.training.designpatterns.structural.decorator.ball.Ball;
import com.scalefocus.training.designpatterns.structural.decorator.ball.BasicBall;
import com.scalefocus.training.designpatterns.structural.decorator.ball.PurpleBall;
import com.scalefocus.training.designpatterns.structural.decorator.ball.WhiteBall;

public class TrainingApp {

    public static void main(String[] args) {

        Ball basicBall = new BasicBall();
        Ball whiteBall = new WhiteBall(basicBall);
        whiteBall.color();
        Ball purpleBall = new PurpleBall(basicBall);
        purpleBall.color();
    }
}

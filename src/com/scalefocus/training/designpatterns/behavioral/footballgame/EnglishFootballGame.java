package com.scalefocus.training.designpatterns.behavioral.footballgame;

/**
 * @author Kristiyan SLavov
 *
 * The Abstract Class. It contains the buildFootballGame method ("the template method")
 * which should be made final so that it cannot be overriden. This template method makes use of other
 * operations available in order to run the algorithm but is decoupled
 * for the actual implementation of these methods.
 * All or most of operations used by this template method are made abstract,
 * so their implementation is deferred to subclasses.
 */
public abstract class EnglishFootballGame {

    // Final template method, so subclasses can't override it
    public final void buildFootballGame() {
        statingTime();
        getStadium();
        getReferee();
        getBall();
        getHomeTeam();
        getAwayTeam();
    }

    public abstract void getStadium();

    public abstract void getReferee();

    public abstract void getHomeTeam();

    public abstract void getAwayTeam();

    // Default implementation of startingTime method
    public void statingTime() {
        System.out.println("The game starts on Sunday, at 17 pm.");
    }

    // Default implementation of getBall method
    public void getBall() {
        System.out.println("The ball is Nike Merlin and it's the Official Premier League Ball.");
    }
}

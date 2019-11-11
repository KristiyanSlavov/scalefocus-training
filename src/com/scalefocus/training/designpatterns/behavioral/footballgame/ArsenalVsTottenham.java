package com.scalefocus.training.designpatterns.behavioral.footballgame;

/**
 * @author Kristiyan SLavov
 *
 * The Concrete Class 2. It implements all the operations required by the templateMethod
 * that were defined as abstract in the parent class. There can be many different ConcreteClasses.
 */
public class ArsenalVsTottenham extends EnglishFootballGame {

    @Override
    public void getStadium() {
        System.out.println("The stadium is Emirates Stadium at London.");
    }

    @Override
    public void getReferee() {
        System.out.println("The referee of the game is Howard Webb");
    }

    @Override
    public void getHomeTeam() {
        System.out.println("The Home Team is Arsenal.");
    }

    @Override
    public void getAwayTeam() {
        System.out.println("The Away Team is Tottenham.");
    }
}

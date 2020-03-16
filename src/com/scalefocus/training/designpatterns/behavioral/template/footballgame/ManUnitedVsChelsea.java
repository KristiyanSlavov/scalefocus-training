package com.scalefocus.training.designpatterns.behavioral.template.footballgame;

/**
 * @author Kristiyan SLavov
 *
 * The Concrete Class 1. It implements all the operations required by the templateMethod
 * that were defined as abstract in the parent class. There can be many different ConcreteClasses.
 */
public class ManUnitedVsChelsea extends EnglishFootballGame{

    @Override
    public void getStadium() {
        System.out.println("The stadium is Old Trafford at Manchester.");
    }

    @Override
    public void getReferee() {
        System.out.println("The referee of the game is Mark Clatenberg");
    }

    @Override
    public void getHomeTeam() {
        System.out.println("The Home Team is Manchester United.");
    }

    @Override
    public void getAwayTeam() {
        System.out.println("The Away Team is Chelsea.");
    }
}

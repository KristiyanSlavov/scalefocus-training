package com.scalefocus.training.designpatterns.structural.bridge.footballteam;

/**
 * @author Kristiyan SLavov
 */
public abstract class FootballCoachDecisions {

    //reference to the implementor
    private FootballTeam theTeam;

    public FootballCoachDecisions(FootballTeam newTeam) {
        this.theTeam = newTeam;
    }

    public void changeTeamSchema(String newSchema) {
        this.theTeam.changeTeamSchema(newSchema);
    }

    public void changePlayer(String player1, String player2) {
        this.theTeam.changePlayer(player1, player2);
    }

    public void getDefaultSchema(){
        this.theTeam.getDefaultSchema();
    }

    public abstract void makeDecision();
}

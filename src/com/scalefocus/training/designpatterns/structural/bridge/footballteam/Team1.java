package com.scalefocus.training.designpatterns.structural.bridge.footballteam;

/**
 * @author Kristiyan SLavov
 */
public class Team1 extends FootballTeam {

    public Team1(String newTeamSchema) {
        schema = newTeamSchema;
    }

    @Override
    public void changeTeamSchema(String newSchema) {
        System.out.println("The Team1 new schema is: " + newSchema);
    }

    @Override
    public void changePlayer(String player1, String player2) {
        System.out.println("The player " + player1 + " is substituted with " + player2);
    }
}

package com.scalefocus.training.designpatterns.structural.bridge.footballteam;

/**
 * @author Kristiyan SLavov
 */
public abstract class FootballTeam {

    protected String schema;

    public abstract void changeTeamSchema(String newSchema);

    public abstract void changePlayer(String player1, String player2);

    public void getDefaultSchema() {
        System.out.println("The default schema of the team is: " + this.schema);
    }
}

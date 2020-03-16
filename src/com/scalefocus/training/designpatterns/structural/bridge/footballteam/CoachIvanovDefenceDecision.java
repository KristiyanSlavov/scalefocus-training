package com.scalefocus.training.designpatterns.structural.bridge.footballteam;

/**
 * @author Kristiyan SLavov
 */
public class CoachIvanovDefenceDecision extends FootballCoachDecisions {

    public CoachIvanovDefenceDecision(FootballTeam newTeam) {
        super(newTeam);
    }

    @Override
    public void makeDecision() {
        System.out.println("Everyone on defence!");
    }
}

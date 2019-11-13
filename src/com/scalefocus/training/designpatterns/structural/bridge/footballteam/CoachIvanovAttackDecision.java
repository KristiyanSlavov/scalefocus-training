package com.scalefocus.training.designpatterns.structural.bridge.footballteam;

/**
 * @author Kristiyan SLavov
 */
public class CoachIvanovAttackDecision extends FootballCoachDecisions {

    public CoachIvanovAttackDecision(FootballTeam newTeam) {
        super(newTeam);
    }

    @Override
    public void makeDecision() {
        System.out.println("Everyone on attack!");
    }
}

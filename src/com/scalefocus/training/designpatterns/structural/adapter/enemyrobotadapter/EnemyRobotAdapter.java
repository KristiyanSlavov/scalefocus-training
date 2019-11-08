package com.scalefocus.training.designpatterns.structural.adapter.enemyrobotadapter;

/**
 * @author Kristiyan SLavov
 *
 * The adapter pattern that converts the interface of a class into another interface clients expect.
 * It lets classes wotk together that couldn't otherwise because of incompatible interfaces.
 */
public class EnemyRobotAdapter implements EnemyAttacker {

    private EnemyRobot enemyRobot;

    public EnemyRobotAdapter(EnemyRobot enemyRobot) {
        this.enemyRobot = enemyRobot;
    }

    @Override
    public void fireWeapon() {
        enemyRobot.smashWithHand();
    }

    @Override
    public void driveForward() {
        enemyRobot.walkForward();
    }

    @Override
    public void assignDriver(String name) {
        enemyRobot.reactToHuman(name);
    }
}

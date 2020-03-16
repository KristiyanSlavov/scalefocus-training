package com.scalefocus.training.designpatterns.structural.adapter.enemyrobotadapter;

/**
 * @author Kristiyan SLavov
 *
 * An Enemy Attacker interface that has a fire weapon, drive forward and can assign a driver
 */
public interface EnemyAttacker {

    void fireWeapon();

    void driveForward();

    void assignDriver(String name);
}

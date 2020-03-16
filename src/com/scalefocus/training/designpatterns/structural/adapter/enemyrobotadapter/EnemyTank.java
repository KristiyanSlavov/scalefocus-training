package com.scalefocus.training.designpatterns.structural.adapter.enemyrobotadapter;

/**
 * @author Kristiyan SLavov
 *
 */
public class EnemyTank implements EnemyAttacker {

    @Override
    public void fireWeapon() {
        int attackDamage = 5;
        System.out.println("The Enemy Tank does" + attackDamage + "damage.");
    }

    @Override
    public void driveForward() {
        int movement = 3;
        System.out.println("The Enemy Tank moves" + movement + "spaces.");
    }

    @Override
    public void assignDriver(String name) {
        System.out.println(name + " is driving The Enemy Tank.");
    }
}

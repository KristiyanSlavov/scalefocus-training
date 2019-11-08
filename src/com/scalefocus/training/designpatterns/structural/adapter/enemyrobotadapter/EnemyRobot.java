package com.scalefocus.training.designpatterns.structural.adapter.enemyrobotadapter;

/**
 * @author Kristiyan SLavov
 */
public class EnemyRobot {

    public void smashWithHand() {
        int attackDamage = 7;
        System.out.println("The Enemy Robot causes " + attackDamage + " damage with it's hand.");
    }

    public void walkForward() {
        int movement = 5;
        System.out.println("The Enemy Robot walks forward " + movement + " spaces.");
    }

    public void reactToHuman(String name) {
        System.out.println("The Enemy Robot Tramps on " + name);
    }
}

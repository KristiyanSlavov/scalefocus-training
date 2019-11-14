package com.scalefocus.training;

import com.scalefocus.training.designpatterns.behavioral.interpreter.AndExpression;
import com.scalefocus.training.designpatterns.behavioral.interpreter.Expression;
import com.scalefocus.training.designpatterns.behavioral.interpreter.OrExpression;
import com.scalefocus.training.designpatterns.behavioral.interpreter.TerminalExpression;

public class TrainingApp {

    public static Expression getEnglishClubExpression() {
        Expression liverpool = new TerminalExpression("Liverpool");
        Expression chelsea = new TerminalExpression("Chelsea");
        return new OrExpression(liverpool, chelsea);
    }

    public static Expression getLiverpoolChampionExpression() {
        Expression liverpool = new TerminalExpression("Liverpool");
        Expression champion = new TerminalExpression("Champion");
        return new AndExpression(liverpool, champion);
    }

    public static void main(String[] args) {
        Expression isEnglishClub = getEnglishClubExpression();
        Expression isLiverpoolChampion = getLiverpoolChampionExpression();

        isLiverpoolChampion.interpret("Liverpool Champion");

        System.out.println("Liverpool is English Football Club? " + isEnglishClub.interpret("Liverpool"));
        System.out.println("Chelsea is English Football Club? " + isEnglishClub.interpret("Chelsea"));
        System.out.println("Milan is English Football Club? " + isEnglishClub.interpret("Milan"));
        System.out.println("Liverpool is champion? " + isLiverpoolChampion.interpret("Liverpool Champion"));
    }
}
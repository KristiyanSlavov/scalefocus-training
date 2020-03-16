package com.scalefocus.training.designpatterns.behavioral.interpreter;

/**
 * The Expression Interface.
 * It declares an interpret operation that terminal and nonterminal expressions will implement.
 *
 * @author Kristiyan SLavov
 */
public interface Expression {

    boolean interpret(String context);
}

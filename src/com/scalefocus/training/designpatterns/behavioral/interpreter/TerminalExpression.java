package com.scalefocus.training.designpatterns.behavioral.interpreter;

/**
 * The TerminalExpression class - implements the Expression interface for terminal expressions.
 * It checks if the data is is the same as the interpreter data(context);
 *
 * @author Kristiyan SLavov
 */
public class TerminalExpression implements Expression {

    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        return context.contains(data);
    }
}

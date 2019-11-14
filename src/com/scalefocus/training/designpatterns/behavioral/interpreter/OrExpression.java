package com.scalefocus.training.designpatterns.behavioral.interpreter;

/**
 * The OrExpression class - implements the Expression interface.
 * It just returns the OR condition of the data is same as the interpreter data.
 *
 * @author Kristiyan SLavov
 */
public class OrExpression implements Expression {

    private Expression firstExpression;

    private Expression secondExpression;

    public OrExpression(Expression firstExpression, Expression secondExpression) {
        this.firstExpression = firstExpression;
        this.secondExpression = secondExpression;
    }

    @Override
    public boolean interpret(String context) {
        return firstExpression.interpret(context) || secondExpression.interpret(context);
    }
}

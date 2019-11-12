package com.scalefocus.training.designpatterns.behavioral.strategy.payment;

/**
 * @author Kristiyan SLavov
 *
 * The Strategy Interface - it declares operation common to all
 * supported versions of some algorithm. The context uses this
 * interface to call the algorithm defined by the concrete strategies.
 */
public interface PaymentStrategy {

    void pay(double amount);
}

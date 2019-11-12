package com.scalefocus.training.designpatterns.behavioral.strategy.payment;

/**
 * @author Kristiyan SLavov
 *
 * The Concrete Strategy 2 - implements the algorithm (pay method) while following
 * the base strategy interface. The interface makes them interchangeable in the context.
 */
public class PayPal implements PaymentStrategy {

    private String id;

    private String password;

    public PayPal(String id, String password) {
        this.id = id;
        this.password = password;
    }

    @Override
    public void pay(double amount) {
        System.out.println(amount + " paid using PayPal.");
        System.out.println("ID: " + id + " | password: " + password);
    }
}

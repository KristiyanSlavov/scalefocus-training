package com.scalefocus.training.designpatterns.behavioral.strategy.payment;

/**
 * @author Kristiyan SLavov
 *
 * The Concrete Strategy 1 - implements the algorithm (pay method) while following
 * the base strategy interface. The interface makes them interchangeable in the context.
 */
public class CreditCard implements PaymentStrategy {

    private String name;

    private String cardNumber;

    private String cvv;

    private String dateOfExpiry;

    public CreditCard(String name, String cardNumber, String cvv, String dateOfExpiry) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.dateOfExpiry = dateOfExpiry;
    }

    @Override
    public void pay(double amount) {
        System.out.println(amount + " paid with credit card.");
        System.out.println(name + " : " + "credit card number - " + cardNumber + " | cvv - " + cvv
                            + " | date of expiry - " + dateOfExpiry);
    }
}

package com.scalefocus.training.designpatterns.behavioral.strategy.payment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kristiyan SLavov
 *
 * This class represents a shopping cart. It contains:
 * An array list with shopping item/s.
 * addItem method which adds a new item to the list.
 * removeItem method which removes a specific item from the list.
 * calculateTotal method which calculates the total amount of the items in the list.
 * pay method which accepts a different payment strategy - CredityCard strategy or PayPal strategy.
 */
public class ShoppingCart {

    private List<Item> items;
    private PaymentStrategy paymentStrategy;

    public ShoppingCart(PaymentStrategy paymentStrategy) {
        this.items = new ArrayList<>();
        this.paymentStrategy = paymentStrategy;
    }

    /**
     * This method adds a new item to the list.
     *
     * @param newItem - the item to be added
     */
    public void addItem(Item newItem) {
        this.items.add(newItem);
    }

    /**
     * This method removes a specific item from the list.
     *
     * @param item - the item to be removed
     */
    public void removeItem(Item item) {
        this.items.remove(item);
    }

    /**
     * This method calculates the total amount of the items in the list.
     *
     * @return - the total amount of the items
     */
    private double calculateTotal(){
        double sum = 0.0d;
        for (Item item: items) {
            sum += item.getPrice();
        }
        return sum;
    }

    /**
     * This method accepts a different payment strategy to pay the amount.
     * The payment strategies are - CreditCard strategy or PayPal strategy.
     *
    // * @param paymentMethod - the payment strategy which will be used to pay the total amount.
     */
    public void pay() {
        double amount = calculateTotal();
        paymentStrategy.pay(amount);
    }
}

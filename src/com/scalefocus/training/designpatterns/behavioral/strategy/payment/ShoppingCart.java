package com.scalefocus.training.designpatterns.behavioral.strategy.payment;

import com.scalefocus.training.designpatterns.structural.composite.shape.Shape;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kristiyan SLavov
 */
public class ShoppingCart {

    private List<Item> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item newItem) {
        this.items.add(newItem);
    }

    public void removeItem(Item item) {
        this.items.remove(item);
    }

    public double calculateTotal(){
        double sum = 0.0d;
        for (Item item: items) {
            sum += item.getPrice();
        }
        return sum;
    }

    public void pay(PaymentStrategy paymentMethod) {
        double amount = calculateTotal();
        paymentMethod.pay(amount);
    }
}

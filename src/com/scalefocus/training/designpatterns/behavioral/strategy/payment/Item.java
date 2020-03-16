package com.scalefocus.training.designpatterns.behavioral.strategy.payment;

/**
 * @author Kristiyan SLavov
 *
 * The class represents a shopping item with two properties - itemCode and price.
 * Also it has two methods: getItemCode method which returns the item's code
 * and getPrice method which returns the item's price.
 */
public class Item {

    private String itemCode;

    private double price;

    public Item(String itemCode, double price) {
        this.itemCode = itemCode;
        this.price = price;
    }

    /**
     * This method returns the shopping item's code.
     *
     * @return - the shopping item's code
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * This method returns the shopping item's price.
     *
     * @return - the shopping item's price
     */
    public double getPrice() {
        return price;
    }
}

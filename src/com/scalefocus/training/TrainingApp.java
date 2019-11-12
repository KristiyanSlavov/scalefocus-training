package com.scalefocus.training;

import com.scalefocus.training.designpatterns.behavioral.strategy.payment.CreditCard;
import com.scalefocus.training.designpatterns.behavioral.strategy.payment.Item;
import com.scalefocus.training.designpatterns.behavioral.strategy.payment.PayPal;
import com.scalefocus.training.designpatterns.behavioral.strategy.payment.ShoppingCart;

public class TrainingApp {

    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        Item tShirt = new Item("ABC123", 15.50);
        Item jeans = new Item("QWE", 14.50);
        shoppingCart.addItem(tShirt);
        shoppingCart.addItem(jeans);
//        shoppingCart.pay(new CreditCard("Kristiyan Slavov", "11223344556677",
//                                            "789", "11/11/2020"));
//
        shoppingCart.pay(new PayPal("123qwe", "ewq321"));
    }
}
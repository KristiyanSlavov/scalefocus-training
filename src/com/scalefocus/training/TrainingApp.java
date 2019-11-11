package com.scalefocus.training;

import com.scalefocus.training.designpatterns.structural.facade.BankAccountFacade;

public class TrainingApp {

    public static void main(String[] args) {

        BankAccountFacade bankAccount = new BankAccountFacade(1122334455, 1234);
        bankAccount.withdrawCash(50);
        bankAccount.withdrawCash(950);
        bankAccount.depositCash(1000);
        bankAccount.withdrawCash(1000);
        bankAccount.withdrawCash(1);
    }
}

package com.scalefocus.training.designpatterns.structural.facade;

/**
 * @author Kristiyan SLavov
 *
 * The funds check class.
 * It provides getCashInAccount method that returns the available fund,
 * decreaseCash method that decreases the cash in the account with the specified cash,
 * icreaseCash method that increases the cash in the account with the specified cash,
 * haveEnoughMoney method that checks if the cash in the account is less than the specified cash
 * and makeDeposit method that uses increaseCash method to increases the cash int the account with
 * the specified cash.
 */
public class FundsCheck {

    private double cashInAccount = 1000d;

    /**
     * This method returns the available funds from the account.
     *
     * @return - the available funds
     */
    public double getCashInAccount() {
        return this.cashInAccount;
    }

    /**
     * This method decreases the cash in the account with the specified cash.
     *
     * @param cashWithdrawn - the specified cash with which the account balance will be reduced
     */
    public void decreaseCash(double cashWithdrawn) {
        cashInAccount -= cashWithdrawn;
    }

    /**
     * This method increases the cash in the account with the specified cash.
     *
     * @param cashDeposited - the specified cash with which the account balance will be increased
     */
    public void increaseCash(double cashDeposited) {
        cashInAccount += cashDeposited;
    }

    /**
     * This method checks if the cash in the account is less than the specified cash.
     *
     * @param cash - the cash to be checked for availability
     *
     * @return - true if the account has less than or equal to the specified cash
     */
    public boolean haveEnoughMoney(double cash) {
        return !(cash > cashInAccount);
    }

    /**
     * This method uses increaseCash method to increases the cash int the account with the specified cash (to make
     * a deposit into the account).
     *
     * @param cash - the cash to be deposited into the account
     */
    public void makeDeposit(double cash) {
        increaseCash(cash);
    }
}

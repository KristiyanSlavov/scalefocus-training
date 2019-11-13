package com.scalefocus.training.designpatterns.structural.facade;

/**
 * @author Kristiyan SLavov
 *
 * The account number check class.
 * It provides getAccountNumber method that returns the account number and
 * isAccountActive method that checks if the specified account number is the correct one.
 */
public class AccountNumberService {

    private int accountNumber = 1122334455;

    /**
     * This method returns the account number.
     *
     * @return - the account number
     */
    public int getAccountNumber() {
        return this.accountNumber;
    }

    /**
     * This method checks if the specified account number is the correct one.
     *
     * @param accountNumber - the account number to be check if it is the correct one
     * @return - true if the specified account number is the correct
     */
    public boolean isActive(int accountNumber) {
        return accountNumber == this.accountNumber;
    }
}

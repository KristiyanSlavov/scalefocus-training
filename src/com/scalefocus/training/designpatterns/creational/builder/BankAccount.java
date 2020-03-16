package com.scalefocus.training.designpatterns.creational.builder;

/**
 * @author Kristiyan SLavov
 */
public class BankAccount {

    private long accountNumber;

    private String owner;

    private String branch;

    private double balance;

    private double interestRate;

    /**
     * @return - the bank account number
     */
    public long getAccountNumber() {
        return accountNumber;
    }

    /**
     * @return - the bank account owner
     */
    public String getOwner() {
        return owner;
    }

    /**
     * @return - the branch at which the bank account was opened
     */
    public String getBranch() {
        return branch;
    }

    /**
     * @return - the bank account balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @return - the bank account interest rate
     */
    public double getInterestRate() {
        return interestRate;
    }

    private BankAccount() { }

    /**
     * The inner class copies all the outer's class attributes (required and optional)
     * and create an instance of the outer class.
     */
    public static class BankAccountBuilder {

        private long accountNumber;

        private String owner;

        private String branch;

        private double balance;

        private double interestRate;

        /**
         * Constructor for required params
         *
         * @param accountNumber - the bank account number
         * @param owner - the bank account owner
         */
        public BankAccountBuilder(long accountNumber, String owner) {
            this.accountNumber = accountNumber;
            this.owner = owner;
        }

        /**
         * This method sets the branch at which the bank account was opened.
         *
         * @param branch - the branch at which the bank account was opened
         * @return - the builder object
         */
        public BankAccountBuilder atBranch(String branch) {
            this.branch = branch;
            return this;
        }

        /**
         * This method sets the balance of the bank account.
         *
         * @param balance - the balance to be set
         * @return - the builder object
         */
        public BankAccountBuilder openingBalance(double balance) {
            this.balance = balance;
            return this;
        }

        /**
         * This method sets the interest rate of the bank account.
         *
         * @param interestRate - the interest rate to be set
         * @return - the builder object
         */
        public BankAccountBuilder atRate(double interestRate) {
            this.interestRate = interestRate;
            return this;
        }

        /**
         * This method returns an instance of type BankAccount and it is the only way
         * to create an instance this type.
         *
         * @return - an instance of type BankAccount
         */
        public BankAccount build() {
            BankAccount bankAccount = new BankAccount();
            bankAccount.accountNumber = this.accountNumber;
            bankAccount.owner = this.owner;
            bankAccount.branch = this.branch;
            bankAccount.balance = this.balance;
            bankAccount.interestRate = this.interestRate;

            return bankAccount;
        }
    }
}

package com.scalefocus.training.designpatterns.structural.facade;

/**
 * @author Kristiyan SLavov
 * <p>
 * The bank account facade class.
 * This is an implementation of the Facade Design Pattern.
 * It combines the functionality of the AccountNumberCheck, SecurityCodeCheck and FundsCheck
 * classes into one and also provides validation of the account number and the security code
 * and withdrawal from the account.
 */
public class BankAccountFacade {

    private final int accountNumber;

    private final int securityCode;

    private final AccountNumberService accountNumberServiceChecker;

    private final SecurityCodeService securityCodeChecker;

    private final FundsService fundsServiceChecker;

    public BankAccountFacade(int accNumber, int secCode) {
        accountNumber = accNumber;
        securityCode = secCode;

        accountNumberServiceChecker = new AccountNumberService();
        securityCodeChecker = new SecurityCodeService();
        fundsServiceChecker = new FundsService();
    }

    /**
     * This method returns the account number.
     *
     * @return - the account number
     */
    private int getAccountNumber() {
        return this.accountNumber;
    }

    /**
     * This method returns the security code.
     *
     * @return - the security code
     */
    private int getSecurityCode() {
        return securityCode;
    }

    /**
     * This method checks whether the specified cash is available in the account
     * and if so then the cash is withdrawn from the account.
     *
     * @param cash - the cash to be withdrawn from the account
     */
    public void withdrawCash(double cash) {
        if (isAccountValid() && fundsServiceChecker.isCashAvailable(cash)) {
            System.out.println("Transaction complete!");
            fundsServiceChecker.decreaseCash(cash);
        } else {
            System.out.println("Transaction failed!");
        }
    }

    /**
     * This method deposits the specified cash into the account.
     *
     * @param cash - the cash to be deposited into the account
     */
    public void depositCash(double cash) {
        if (isAccountValid()) {
            fundsServiceChecker.makeDeposit(cash);
            System.out.println("Transaction complete!");
        } else {
            System.out.println("Transaction false!");
        }
    }

    /**
     * This method checks if the account number and
     * the security code are valid.
     *
     * @return - true if the account number and the security code are valid
     */
    private boolean isAccountValid() {
        return accountNumberServiceChecker.isActive(getAccountNumber()) &&
                securityCodeChecker.isSecurityCodeCorrect(getSecurityCode());
    }
}

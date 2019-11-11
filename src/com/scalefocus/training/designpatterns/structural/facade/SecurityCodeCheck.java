package com.scalefocus.training.designpatterns.structural.facade;

/**
 * @author Kristiyan SLavov
 *
 * The security code check class.
 * It provides getSecurityCode method that returns the security code and
 * isSecurityCodeCorrect method that checks if the specified security code is the correct one.
 */
public class SecurityCodeCheck {

    private int securityCode = 1234;

    /**
     * This method returns the security code.
     *
     * @return - the security code
     */
    public int getSecurityCode() {
        return this.securityCode;
    }

    /**
     * This method checks if the specified security code is the correct one.
     *
     * @param securityCode - the security code to be check if it is the correct one
     * @return - true if the specified security code is the correct
     */
    public boolean isSecurityCodeCorrect(int securityCode) {
        return securityCode == this.securityCode;
    }
}

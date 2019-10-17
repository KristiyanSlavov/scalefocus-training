package com.scalefocus.training.algorithm.recursion;

/**
 * @author Kristiyan SLavov
 */
public class Fibonacci {

    private static long prev = 0, next = 1, result = 0;

    /**
     * This method returns number on the specified position, calculated by fibonacci method.
     *
     * @param n - the specified position
     * @return the number calculated by fibonacci method
     */
    public static long fibonacciMethod(int n) {
        if (n > 1) {
            result = prev + next;
            prev = next;
            next = result;
            fibonacciMethod(n - 1);
        }
        return result;
    }
}

package com.scalefocus.training.algorithm.recursion;

/**
 * @author Kristiyan SLavov
 */
public class Fibonacci {

    private static long prev = 0, next = 1, result = 0;

    /**
     * This method returns number on the specified position, calculated by fibonacci method.
     * The method is implemented using memoization technique to speed up the method.
     *
     * @param n - the specified position
     * @return the number calculated by fibonacci method
     */
    public long memoizationFibonacci(int n) {
        if (n > 1) {
            result = prev + next;
            prev = next;
            next = result;
            memoizationFibonacci(n - 1);
        }
        return result;
    }

    /**
     * This method returns number on the specified position, calculated by fibonacci method.
     *
     * @param n - the specified position
     * @return the number calculated by fibonacci method
     */
    public long fibFunction(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return  fibFunction(n - 1) + fibFunction(n - 2);
        }
    }
}

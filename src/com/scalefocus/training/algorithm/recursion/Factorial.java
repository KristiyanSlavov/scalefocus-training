package com.scalefocus.training.algorithm.recursion;

import com.scalefocus.training.collection.link.MyLinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kristiyan SLavov
 */
public class Factorial {

    private static List<Integer> memoizeCache = new ArrayList<>();

    /**
     * This method return factorial of the specified number
     *
     * @param n - the specified number
     * @return the factorial of the specified number
     */
    public static Integer fact(Integer n) {
        //return n == 0 || n == 1 ? 1 : n * fact(n - 1);

        if (n == 0) {
            return 1;
        } else {

            if (memoizeCache.size() >= n) {
                return memoizeCache.get(n - 1);
            }
            int factorial = n * fact(n - 1);
            memoizeCache.add(factorial);
            return factorial;
        }
    }
}

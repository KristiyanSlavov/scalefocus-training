package com.scalefocus.training.algorithm.sort;

/**
 * @author Kristiyan SLavov
 */

public class InsertionSort {

    /**
     * This method sorts the specified array through InsertionSort algorithm.
     *
     * @param array - the array to be sorted
     */
    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                --j;
            }
            array[j + 1] = key;
        }
    }
}

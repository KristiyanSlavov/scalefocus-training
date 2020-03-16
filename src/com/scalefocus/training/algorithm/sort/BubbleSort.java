package com.scalefocus.training.algorithm.sort;

/**
 * @author Kristiyan SLavov
 */
public class BubbleSort {

    /**
     * This method sorts the specified array through BubbleSort algorithm.
     *
     * @param array - the array to be sorted
     */
    public void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}

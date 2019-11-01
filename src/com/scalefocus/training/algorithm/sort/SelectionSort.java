package com.scalefocus.training.algorithm.sort;

/**
 * @author Kristiyan SLavov
 */
public class SelectionSort {

    /**
     * This method sorts the specified array through SelectionSort algorithm.
     *
     * @param array - the array to be sorted
     */
    public void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
}

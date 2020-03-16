package com.scalefocus.training.algorithm.sort;

import java.util.Arrays;

/**
 * @author Kristiyan SLavov
 */
public class QuickSort {

    /**
     * This method sorts the specified array through QuickSort algorithm.
     *
     * @param array      - the array to be sorted
     * @param startIndex - the index of the first element
     * @param endIndex   - the index of the last element
     */
    public void sort(int[] array, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        int partitionIndex = partition(array, startIndex, endIndex);
        sort(array, startIndex, partitionIndex - 1);
        sort(array, partitionIndex + 1, endIndex);
    }

    /**
     * This method selects the last element in the array, marks it as a "pivot"
     * and rearranges thе array as follows, the smaller elements are before the "pivot"
     * and the larger elements are after it.
     *
     * @param array      - the array to be rearrange
     * @param startIndex - the index of the first element
     * @param endIndex   - the index of the last element
     * @return - the partition index
     */
    private static int partition(int[] array, int startIndex, int endIndex) {
        int pivot = array[endIndex];
        int partitionIndex = startIndex;
        for (int i = startIndex; i < endIndex; i++) {
            if (array[i] <= pivot) {
                //swap if element is lesser than the pivot
                int temp = array[i];
                array[i] = array[partitionIndex];
                array[partitionIndex] = temp;
                ++partitionIndex;
            }
        }
        // swap pivot with element at partition index
        int temp = array[partitionIndex];
        array[partitionIndex] = array[endIndex];
        array[endIndex] = temp;

        return partitionIndex;
    }

    /**
     * This method sorts the specified array through QuickSort algorithm using the "median of three approach".
     * This approach always chooses the pivot to be the middle of the three elements in the sub array.
     *
     * @param array - the array to be sorted
     * @param startIndex - the index of the first element
     * @param endIndex - the index of the last element
     */
    public void medianSort(int[] array, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        int partitionIndex = medianPivot(array, startIndex, endIndex);
        sort(array, startIndex, partitionIndex - 1);
        sort(array, partitionIndex + 1, endIndex);
    }

    /**
     * This method returns the index where the pivot will be placed.
     * The pivot is selected trough "median of three approach" where the elements from which the pivot will be selected
     * are the first, the last and the middle element from the specified array.
     *
     * @param array - the array from which will be selected the pivot value
     * @param startIndex - the index of the first element
     * @param endIndex - the index of the last element
     * @return - the index where the pivot will be placed
     */
    private int medianPivot(int[] array, int startIndex, int endIndex) {
        int mid = (startIndex + endIndex) / 2;

        int[] sortingArr = {array[startIndex], array[mid], array[endIndex]};
        Arrays.sort(sortingArr);
        int middleValue = sortingArr[1];
        int temp = array[endIndex];
        array[endIndex] = middleValue;
        if (middleValue == array[startIndex]) {
            array[startIndex] = temp;
        } else if(middleValue == array[mid]) {
            array[mid] = temp;
        }

        return partition(array, startIndex, endIndex);
    }
}

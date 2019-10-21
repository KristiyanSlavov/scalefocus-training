package com.scalefocus.training.algorithm.sort;

/**
 * @author Kristiyan SLavov
 */
public class MergeSort {

    /**
     * This method sorts the specified array through MergeSort algorithm.
     *
     * @param arr - the array to be sorted
     */
    public static void sort(int[] arr) {
        int numberOfElements = arr.length;

        if (numberOfElements < 2) {
            return;
        } else {
            int midPosition = Math.round((float) (numberOfElements) / 2);
            int[] leftArr = new int[midPosition];
            int[] rightArr = new int[numberOfElements - midPosition];

            for (int i = 0; i < midPosition; i++) {
                leftArr[i] = arr[i];
            }
            for (int i = midPosition; i < numberOfElements; i++) {
                rightArr[i - midPosition] = arr[i];
            }

            sort(leftArr);
            sort(rightArr);
            merge(leftArr, rightArr, arr);
        }
    }

    public static void merge(int[] leftArr, int[] rightArr, int[] array) {
        int leftIndex = 0, rightIndex = 0, arrIndex = 0;

        while (leftIndex < leftArr.length && rightIndex < rightArr.length) {
            if (leftArr[leftIndex] < rightArr[rightIndex]) {
                array[arrIndex] = leftArr[leftIndex];
                ++leftIndex;
            } else {
                array[arrIndex] = rightArr[rightIndex];
                ++rightIndex;
            }
            ++arrIndex;
        }

        while (leftIndex < leftArr.length) {
            array[arrIndex] = leftArr[leftIndex];
            ++leftIndex;
            ++arrIndex;
        }

        while (rightIndex < rightArr.length) {
            array[arrIndex] = rightArr[rightIndex];
            ++rightIndex;
            ++arrIndex;
        }
    }
}

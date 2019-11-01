package com.scalefocus.training.algorithm.sort;

import com.scalefocus.training.collection.heap.Heap;

/**
 * @author Kristiyan SLavov
 */
public class HeapSort {

    private Heap heap = new Heap();

    /**
     * This method sort a specified array using HeapSort algorithm.
     * Heap sort is comparison based sorting technique based on Max Heap data structure.
     * It finds the maximum element and place it at the end. It repeats the same process
     * till there is only one element remaining.
     *
     *
     * @param array - the array to be sorted
     */
    public void sort(int[] array) {
        //step 1: build max heap
        //buildMaxHeap(array);
        heap.buildMaxHeap(array);

        //step 2: find last element
        int lastElementIndex = array.length - 1;

        //step 3: continue heap sorting until we have
        // just one element left in the array
        while (lastElementIndex > 0) {
            heap.swap(array, 0, lastElementIndex);
            heap.maxHeapify(array, 0, lastElementIndex);
            lastElementIndex -= 1;
        }
    }
}

package com.scalefocus.training.collection.priorityqueue;

import com.scalefocus.training.collection.heap.Heap;

import java.util.Comparator;

/**
 * @author Kristiyan SLavov
 */
public class PriorityQueue<T extends Comparable> {

    private Object[] heap;

    private int size;

    private Comparator<T> comparator;

    public PriorityQueue(int initialCapacity) {
        this.heap = new Object[initialCapacity];
        this.size = 0;
    }

    public PriorityQueue(int initialCapacity, Comparator<T> comparator) {
        this.heap = new Object[initialCapacity];
        this.comparator = comparator;
        this.size = 0;
    }

    public void swap(int[] array, int firstElementIndex, int lastElementIndex) {
        int temp = array[firstElementIndex];
        array[firstElementIndex] = array[lastElementIndex];
        array[lastElementIndex] = temp;
    }
}

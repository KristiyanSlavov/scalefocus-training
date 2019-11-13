package com.scalefocus.training.collection.priorityqueue;

import com.scalefocus.training.collection.common.MyQueue;

import java.util.Comparator;

/**
 * @author Kristiyan SLavov
 */
public class PriorityQueue<T extends Comparable> implements MyQueue<T> {

    private Object[] heap;

    private int size;

    private Comparator comparator;

    public PriorityQueue(int initialCapacity) {
        this.heap = new Object[initialCapacity];
        this.comparator = Comparator.naturalOrder();
        this.size = 0;
    }

    public PriorityQueue(int initialCapacity, Comparator<T> comparator) {
        this.heap = new Object[initialCapacity];
        this.comparator = comparator;
        this.size = 0;
    }

    /**
     * This method inserts the specified element into the priority queue.
     *
     * @param element - the element to add
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public void push(T element) {
        if (size == heap.length) {
            return;
        }
        heap[size] = element;
        int index = size;

        while (index >= 1 && comparator.compare(heap[index], heap[(index - 1) / 2]) > 0) {
            swap(heap, (index - 1) / 2, index);
            index = (index - 1) / 2;
        }
        size++;
    }

    /**
     * This method retrieves and removes the head of the priority queue, or returns null if
     * the queue is empty.
     *
     * @return - the head of the priority queue, or null if the queue is empty
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public T poll() {
        int length = heap.length;
        if (size == 0) {
            return null;
        }
        T max = (T) heap[0];
        heap[0] = heap[length - 1];
        Object[] helper = new Object[heap.length - 1];

        for (int i = 0; i < length - 1; i++) {
            helper[i] = heap[i];
        }
        heap = helper;
        size--;
        heapify(heap, 0, heap.length);
        return max;
    }

    /**
     * This method transforms a given array into a Min/Max Heap data structure.
     * Whether the structure will be Min Heap or Max Heap is determined by the comparator.
     *
     * @param heap - the array to be transformed
     * @param i - the starting index
     * @param length - the array's length
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    private void heapify(Object[] heap, int i, int length) {
        int current;
        int leftChild;
        int rightChild;

        while (i < length) {
            current = i;
            leftChild = 2 * i + 1;
            rightChild = leftChild + 1;

            if (leftChild < length && comparator.compare(heap[leftChild], heap[current]) > 0) {
                current = leftChild;
            }
            if (rightChild < length && comparator.compare(heap[rightChild], heap[current]) > 0) {
                current = rightChild;
            }
            if (current == i) {
                return;
            }
            swap(heap, i, current);
            i = current;
        }
    }

    /**
     * This method swaps two given elements into the specified array.
     *
     * @param array - the array in which the two given elements will be swapped.
     * @param firstElementIndex - the first element
     * @param lastElementIndex - the second element
     */
    private void swap(Object[] array, int firstElementIndex, int lastElementIndex) {
        Object temp = array[firstElementIndex];
        array[firstElementIndex] = array[lastElementIndex];
        array[lastElementIndex] = temp;
    }

    /**
     * This method retrieves, but don't remove, the head of the priority queue, or returns null
     * if the queue is empty.
     *
     * @return - the head of this queue, or null if the queue is empty.
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public T peek() {
        return size == 0 ? null : (T)heap[0];
    }

    /**
     * This method returns the numbers of elements in this queue or 0 if the queue is empty.
     *
     * @return - the number of elements in this queue or 0 if the queue is empty
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * This method prints all the elements from the queue.
     */
    @Override
    public void print() {
        if(size == 0) {
            return;
        }
        for (Object temp : heap) {
            System.out.print(temp + " ");
        }
    }
}

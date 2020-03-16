package com.scalefocus.training.collection.heap;

/**
 * @author Kristiyan SLavov
 */
public class Heap {

    private int[] heap;

    private int size;

    private static final String MAX = "MAX";

    private static final String MIN = "MIN";

    public Heap() {
    }

    public Heap(int maxSize) {
        size = 0;
        heap = new int[maxSize];
    }

    /**
     * This method creates a Max Heap from a specified array using a buildHeap helper method.
     * The Max Heap is a complete binary tree in which the value in each node is
     * greater than or equal to the values in the children of that node.
     * The Max Heap structure is represented as an array.
     *
     * @param array - the array to be transformed into a Max Heap
     */
    public void buildMaxHeap(int[] array) {
        buildHeap(array, MAX);
    }

    /**
     * This method creates a Min Heap from a specified array using a buildHeap helper method.
     * The Min Heap is a complete binary tree in which the value in each node is
     * lower than or equal to the values in the children of that node.
     * The Min Heap structure is represented as an array.
     *
     * @param array - the array to be transformed into a Min Heap
     */
    public void buildMinHeap(int[] array) {
        buildHeap(array, MIN);
    }

    /**
     * This method creates a Heap structure based on a given array and a factor
     * using minHeapify/maxHeapify healper method.
     * If the factor is equal to MIN, it builds a Min Heap structure.
     * If the factor is equal to MAX, it build a Max Heap structure.
     *
     * @param array - the array to be transformed into a Heap.
     * @param factor - the factor that must determine what Heap should be created, MAX or MIN
     */
    private void buildHeap(int[] array, String factor) {
        int i = (array.length / 2) - 1; //the last non-leaf node
        while (i >= 0) {
            if (factor.equals(MIN)) {
                minHeapify(array, i, array.length);
            } else {
                maxHeapify(array, i, array.length);
            }
            i -= 1;
        }
    }

    public void minHeapify(int[] array, int index, int length) {
        heapify(array, index, length, MIN);
    }

    public void maxHeapify(int[] array, int index, int length) {
        heapify(array, index, length, MAX);
    }

    private void heapify(int[] heap, int i, int length, String factor) {
        int current;
        int leftChild;
        int rightChild;
        while (i < length) {
            current = i;
            leftChild = 2 * i + 1;
            rightChild = leftChild + 1;

            if (factor.equals(MIN)) {
                if (leftChild < length && heap[leftChild] < heap[current]) {
                    current = leftChild;
                }
                if (rightChild < length && heap[rightChild] < heap[current]) {
                    current = rightChild;
                }
            } else {
                if (leftChild < length && heap[leftChild] > (heap[current])) {
                    current = leftChild;
                }
                if (rightChild < length && heap[rightChild] > heap[current]) {
                    current = rightChild;
                }
            }
            if (current == i) {
                return;
            }
            swap(heap, i, current);
            i = current;
        }
    }

    public void swap(int[] array, int firstElementIndex, int lastElementIndex) {
        int temp = array[firstElementIndex];
        array[firstElementIndex] = array[lastElementIndex];
        array[lastElementIndex] = temp;
    }

    public int maximum(int[] array) {
        buildMaxHeap(array);
        return array[0];
    }

    public int extractMaximum(int[] array) {
        buildMaxHeap(array);
        int length = array.length;
        if (length == 0) {
            return -1;
        }
        int max = array[0];
        array[0] = array[length - 1];
        int[] helper = new int[array.length - 1];

        for (int i = 0; i < length - 1; i++) {
            helper[i] = array[i];
        }
        array = helper;
        maxHeapify(array, 0, length);
        return max;
    }

    public void increaseValue(int[] array, int index, int value) {
        if (value < array[index]) {
            return;
        }
        buildMaxHeap(array);
        array[index] = value;
        while (index >= 1 && array[(index - 1) / 2] < array[index]) {
            swap(array, (index - 1) / 2, index);
            index = (index - 1) / 2;
        }
    }

    public boolean insert(int element) {
        if (size == heap.length) {
            return false;
        }
        heap[size] = element;
        int index = size;

        while (index >= 1 && heap[index] > heap[(index - 1) / 2]) {
            swap(heap, (index - 1) / 2, index);
            index = (index - 1) / 2;
        }
        size++;
        return true;
    }

    public int remove() {
        if (heap.length == 0) {
            return -1;
        }

        int popped = heap[0];
        heap[0] = heap[heap.length - 1];

        int[] helper = new int[heap.length - 1];
        for (int i = 0; i < heap.length - 1; i++) {
            helper[i] = heap[i];
        }
        heap = helper;
        size--;
        maxHeapify(heap, 0, heap.length);

        return popped;
    }
}
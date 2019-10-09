package com.scalefocus.training.array;

import com.scalefocus.training.MyList;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MyArrayList implements MyList {

    private Object[] myStore;

    private int myStoreSize = 0;

    private static final int MY_STORE_INITIAL_SIZE = 10;

    private static final double LOAD_FACTOR = 0.75;

    public MyArrayList() {
        myStore = new Object[MY_STORE_INITIAL_SIZE];
    }

    /**
     * This method gets the element on specified index.
     * If index is larger than the size of the list an {@link ArrayIndexOutOfBoundsException} will be thrown.
     *
     * @param index - the index from where an element will be got
     * @return the element that had been got
     */
    public Object get(int index) {
        if (index < myStoreSize) {
            System.out.println("Element: " + myStore[index]);
            return myStore[index];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * This method adds an element in the array.
     *
     * @param data - the value that will be stored in the array
     */
    @Override
    public void add(Object data) {
        myStore[myStoreSize++] = data;
        if (checkMyStoreCapacity()) {
            increaseMyStoreCapacity();
        }
    }

    /**
     * This method inserts an element in the beginning of the array.
     *
     * @param data - the value that will be stored as first element in the array
     */
    @Override
    public void insertAtStart(Object data) {
        Object[] result = new Object[myStore.length + 1];

        for (int i = 0; i < result.length; i++) {
            if (i == 0) {
                result[i] = data;
            } else {
                result[i] = myStore[i - 1];
            }
        }
        myStore = result;
        ++myStoreSize;
    }

    /**
     * This method inserts an element on specified index.
     * If index is larger than the size of the array an {@link ArrayIndexOutOfBoundsException} will be thrown.
     *
     * @param index - the index where an element will be insert
     * @param data  - the value that will be stored on the specified index
     */
    @Override
    public void insertAt(int index, Object data) {
        if (index <= myStoreSize) {
            if (index == 0) {
                insertAtStart(data);
            } else if (index == myStoreSize) {
                add(data);
            } else {
                Object[] result = new Object[myStore.length + 1];

                for (int i = 0; i < result.length; i++) {
                    if (i < index) {
                        result[i] = myStore[i];

                    } else if (i == index) {
                        result[index] = data;

                    } else {
                        result[i] = myStore[i - 1];
                    }
                }
                myStore = result;
                ++myStoreSize;
            }
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * This method removes the element on specified index.
     * If index is larger than the size of the array an {@link ArrayIndexOutOfBoundsException} will be thrown.
     *
     * @param index - the index where an element will be removed
     * @return the element that had been removed
     */
    public Object remove(int index) {
        if (index < myStoreSize - 1) {
            Object target = myStore[index];
            int temp = index;

            while (temp < myStoreSize) {
                myStore[temp] = myStore[temp + 1];
                myStore[temp + 1] = null;
                temp++;
            }
            myStoreSize--;
            return target;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * This method increases the array's capacity by two.
     */
    private void increaseMyStoreCapacity() {
        myStore = Arrays.copyOf(myStore, myStore.length * 2);
    }

    /**
     * This method checks the array's capacity.
     *
     * @return true if the array's capacity needs to be increased and false if not needed.
     */
    public boolean checkMyStoreCapacity() {
        return (double) (myStoreSize) / (double) (myStore.length) > LOAD_FACTOR;
    }

    /**
     * This method returns the size of the list.
     *
     * @return the size of the array
     */
    public int size() {
        return myStoreSize;
    }

    /**
     * This method prints all elements from the list.
     */
    public void print() {
        for (int i = 0; i < myStore.length; i++) {
            if (myStore[i] != null) {
                System.out.println("Element:" + myStore[i]);
            }
        }
    }
}
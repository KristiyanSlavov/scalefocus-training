package com.scalefocus.training.collection.array;

import com.scalefocus.training.collection.common.MyList;

public class MyArrayList<T> implements MyList<T> {

    private Object[] myStore;

    private int myStoreSize = 0;

    private static final int MY_STORE_INITIAL_SIZE = 10;

    private static final double LOAD_FACTOR = 0.75;

    private static final double DECREASE_FACTOR = 0.45;

    @SuppressWarnings({"unchecked", "rawtypes"})
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
    public T get(int index) {
        if (index < myStoreSize) {
            System.out.println("Element: " + myStore[index]);
            return (T) myStore[index];
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
    public void add(T data) {
        myStore[myStoreSize++] = data;
        if (increaseCheck()) {
            increaseMyStoreCapacity();
        }
    }

    /**
     * This method inserts an element in the beginning of the array.
     *
     * @param data - the value that will be stored as first element in the array
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public void insertAtStart(T data) {
        if (increaseCheck()) {
            increaseMyStoreCapacity();
        }
        T[] result = (T[]) new Object[myStore.length];

        for (int i = 0; i < result.length; i++) {
            if (i == 0) {
                result[i] = data;
            } else {
                result[i] = (T) myStore[i - 1];
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
    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public void insertAt(int index, T data) {
        if (index <= myStoreSize) {
            if (index == 0) {
                insertAtStart(data);
            } else if (index == myStoreSize) {
                add(data);
            } else {
                if (increaseCheck()) {
                    increaseMyStoreCapacity();
                }
                T[] result = (T[]) new Object[myStore.length];

                for (int i = 0; i < result.length; i++) {
                    if (i < index) {
                        result[i] = (T) myStore[i];
                    } else if (i == index) {
                        result[index] = data;
                    } else {
                        result[i] = (T) myStore[i - 1];
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
    public T remove(int index) {
        if (index < myStoreSize) {
            T target = (T) myStore[index];
            int temp = index;

            while (temp < myStoreSize) {
                myStore[temp] = myStore[temp + 1];
                myStore[temp + 1] = null;
                temp++;
            }
            myStoreSize--;
            if (decreaseCheck()) {
                decreaseMyStoreCapacity();
            }
            return target;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * This method increases the array's capacity by two.
     */
    private void increaseMyStoreCapacity() {
        Object[] helper = new Object[myStore.length * 2];
        for (int i = 0; i < myStore.length; i++) {
            helper[i] = myStore[i];
        }
        myStore = helper;
    }

    /**
     * This method decreases the array's capacity by two
     */
    private void decreaseMyStoreCapacity() {
        Object[] helper = new Object[myStore.length / 2];
        for (int i = 0; i < helper.length; i++) {
            helper[i] = myStore[i];
        }
        myStore = helper;
    }

    /**
     * This method checks if the array's capacity has to be increase.
     *
     * @return true if the array's capacity has to be increase and false if it's not needed.
     */
    private boolean increaseCheck() {
        return (double) (myStoreSize) / (double) (myStore.length) > LOAD_FACTOR;
    }

    /**
     * This method checks if the array's capacity has to be decrease.
     *
     * @return true if the array's capacity has to be decrease and false if it's not needed.
     */
    private boolean decreaseCheck() {
        return myStore.length > 5 && (double) (myStoreSize) / (double) (myStore.length) <= DECREASE_FACTOR;
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
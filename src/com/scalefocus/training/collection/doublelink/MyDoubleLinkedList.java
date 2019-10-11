package com.scalefocus.training.collection.doublelink;

import com.scalefocus.training.collection.common.MyList;

/**
 * @author Kristiyan SLavov
 */
public class MyDoubleLinkedList<T> implements MyList<T> {

    private DoubleNode<T> head;

    private DoubleNode<T> tail;

    private int size = 0;

    /**
     * This method gets the element on specified index.
     * If index is larger than the size of the list an {@link IndexOutOfBoundsException} will be thrown.
     *
     * @param index - the index from where an element will be got
     * @return the element that had been gotten
     */
    @Override
    public T get(int index) {
        if (index < size) {
            if (index == 0 && head != null) {
                System.out.println("Element at index: " + index + " is: " + head.getValue());
                return head.getValue();

            } else {
                DoubleNode<T> currentDoubleNode = head;
                for (int i = 0; i < index; i++) {
                    currentDoubleNode = currentDoubleNode.getNext();
                }
                assert currentDoubleNode != null;
                System.out.println("Element at index: " + index + " is: " + currentDoubleNode.getValue());
                return currentDoubleNode.getValue();
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     *This method adds an element in the list.
     *
     * @param data - the value that will be stored in the list
     */
    @Override
    public void add(T data) {
        DoubleNode<T> doubleNode = new DoubleNode<>(data);

        if (head == null) {
            head = doubleNode;
            tail = doubleNode;
        } else {
            DoubleNode<T> currentDoubleNode = tail;
            currentDoubleNode.setNext(doubleNode);
            doubleNode.setPrevious(currentDoubleNode);
            tail = doubleNode;
        }
        ++size;
    }

    /**
     * This method inserts an element in the beginning of the list.
     *
     * @param data - the value that will be stored as first element in the list
     */
    @Override
    public void insertAtStart(T data) {
        DoubleNode<T> doubleNode = new DoubleNode<>(data);
        doubleNode.setNext(head);
        doubleNode.setPrevious(null);

        if (head != null) {
            head.setPrevious(doubleNode);
        }
        head = doubleNode;
        ++size;
    }

    /**
     * This method inserts an element on specified index.
     * If index is larger than the size of the list an {@link IndexOutOfBoundsException} will be thrown.
     *
     * @param index - the index where an element will be insert
     * @param data - the value that will be stored on the specified index
     */
    @Override
    public void insertAt(int index, T data) {
        if (index <= size) {

            if (index == 0) {
                insertAtStart(data);
            } else if (index == size) {
                add(data);
            } else {
                DoubleNode<T> doubleNode = new DoubleNode<>(data);
                DoubleNode<T> currentDoubleNode = head;
                DoubleNode<T> afterCurrentDoubleNode;

                for (int i = 0; i < index - 1; i++) {
                    currentDoubleNode = currentDoubleNode.getNext();
                }

                afterCurrentDoubleNode = currentDoubleNode.getNext();
                currentDoubleNode.setNext(doubleNode);
                afterCurrentDoubleNode.setPrevious(doubleNode);
                doubleNode.setNext(afterCurrentDoubleNode);
                doubleNode.setPrevious(currentDoubleNode);
                ++size;
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * This method removes the element on specified index.
     * If index is larger than the size of the list an {@link IndexOutOfBoundsException} will be thrown.
     *
     * @param index - the index where an element will be removed
     * @return the element that had been removed
     */
    @Override
    public T remove(int index) {
        if (index < size) {
            DoubleNode<T> target;
            DoubleNode<T> afterTargetDoubleNode;

            if (index == 0) {
                target = head;
                head = head.getNext();
                head.setPrevious(null);
                return target.getValue();
            } else {
                DoubleNode<T> currentDoubleNode = head;

                for (int i = 0; i < index - 1; i++) {
                    currentDoubleNode = currentDoubleNode.getNext();
                }
                target = currentDoubleNode.getNext();
                afterTargetDoubleNode = target.getNext();
                currentDoubleNode.setNext(target.getNext());
                afterTargetDoubleNode.setPrevious(target.getPrevious());

                --size;
                return target.getValue();
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * This method returns the size of the list.
     *
     * @return the size of the list
     */
    public int size() {
        return size;
    }

    /**
     * This method prints all elements from the list.
     */
    @Override
    public void print() {
        DoubleNode<T> currentDoubleNode = head;

        while (currentDoubleNode.getNext() != null) {

            System.out.println(currentDoubleNode.getValue());
            currentDoubleNode = currentDoubleNode.getNext();
        }
        System.out.println(currentDoubleNode.getValue());
    }
}

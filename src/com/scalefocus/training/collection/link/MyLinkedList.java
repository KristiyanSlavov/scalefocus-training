package com.scalefocus.training.collection.link;

import com.scalefocus.training.collection.common.BaseNode;
import com.scalefocus.training.collection.common.MyList;
import com.scalefocus.training.collection.common.Node;

public class MyLinkedList<T> implements MyList<T> {

    private BaseNode<T> head;

    private BaseNode<T> tail;

    private int size = 0;

    /**
     * This method adds an element in the list.
     *
     * @param data - the value that will be stored in the list
     */
    public void add(T data) {
        BaseNode<T> node = new BaseNode<>(data);

        if (head == null) {
            head = node;
            tail = node;

        } else {
            BaseNode<T> currentNode = tail;
            currentNode.setNext(node);
            tail = node;
        }
        ++size;
    }

    /**
     * This method inserts an element in the beginning of the list.
     *
     * @param data - the value that will be stored as first element in the list
     */
    public void insertAtStart(T data) {
        BaseNode<T> node = new BaseNode<>(data);

        node.setNext(head);
        head = node;
        ++size;
    }

    /**
     * This method inserts an element on specified index.
     * If index is larger than the size of the list an {@link IndexOutOfBoundsException} will be thrown.
     *
     * @param index - the index where an element will be insert
     * @param data  - the value that will be stored on the specified index
     */
    public void insertAt(int index, T data) {
        if (index <= size) {

            if (index == 0) {
                insertAtStart(data);
            } else if (index == size) {
                add(data);
            } else {
                BaseNode<T> node = new BaseNode<>(data);

                BaseNode<T> currentNode = head;
                for (int i = 0; i < index - 1; i++) {
                    currentNode = currentNode.getNext();
                }

                node.setNext(currentNode.getNext());
                currentNode.setNext(node);
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
            BaseNode<T> target;

            if (index == 0) {
                target = head;
                head = head.getNext();
                --size;

                return target.getValue();
            } else {
                BaseNode<T> currentNode = head;

                for (int i = 0; i < index - 1; i++) {
                    currentNode = currentNode.getNext();
                }

                target = currentNode.getNext();
                if (target.getNext() == null) {
                    tail = currentNode;
                }
                currentNode.setNext(target.getNext());
                --size;

                System.out.println("Delete element: " + target.getValue());
                return target.getValue();
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * This method gets the element on specified index.
     * If index is larger than the size of the list an {@link IndexOutOfBoundsException} will be thrown.
     *
     * @param index - the index from where an element will be got
     * @return the element that had been got
     */
    public T get(int index) {
        if (index < size) {
            BaseNode<T> currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.getNext();
            }
            System.out.println("Element at index: " + index + " is: " + currentNode.getValue());
            return currentNode.getValue();
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
    public void print() {
        Node currentNode = head;

        while (currentNode.getNext() != null) {
            System.out.println(currentNode.getValue());
            currentNode = currentNode.getNext();
        }
        System.out.println(currentNode.getValue());
    }

}

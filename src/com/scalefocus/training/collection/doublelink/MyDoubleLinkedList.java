package com.scalefocus.training.collection.doublelink;

import com.scalefocus.training.collection.common.MyList;

/**
 * @author Kristiyan SLavov
 */
public class MyDoubleLinkedList implements MyList {

    private Node head;

    private Node tail;

    private int size = 0;

    /**
     * This method gets the element on specified index.
     * If index is larger than the size of the list an {@link IndexOutOfBoundsException} will be thrown.
     *
     * @param index - the index from where an element will be got
     * @return the element that had been gotten
     */
    @Override
    public Object get(int index) {
        if (index < size) {
            if (index == 0 && head != null) {
                System.out.println("Element at index: " + index + " is: " + head.getValue());
                return head.getValue();

            } else {
                Node currentNode = head;
                for (int i = 0; i < index; i++) {
                    currentNode = currentNode.getNext();
                }
                System.out.println("Element at index: " + index + " is: " + currentNode.getValue());
                return currentNode.getValue();
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
    public void add(Object data) {
        Node node = new Node(data);

        if (head == null) {
            head = node;
            tail = node;
        } else {
            /*
            Node currentNode = head;
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(node);
            node.setPrevious(currentNode);
            */
            Node currentNode = tail;
            currentNode.setNext(node);
            node.setPrevious(currentNode);
            tail = node;
        }
        ++size;
    }

    /**
     * This method inserts an element in the beginning of the list.
     *
     * @param data - the value that will be stored as first element in the list
     */
    @Override
    public void insertAtStart(Object data) {
        Node node = new Node(data);
        node.setNext(head);
        node.setPrevious(null);

        if (head != null) {
            head.setPrevious(node);
        }
        head = node;
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
    public void insertAt(int index, Object data) {
        if (index <= size) {

            if (index == 0) {
                insertAtStart(data);
            } else if (index == size) {
                add(data);
            } else {
                Node node = new Node(data);
                Node currentNode = head;
                Node afterCurrentNode;

                for (int i = 0; i < index - 1; i++) {
                    currentNode = currentNode.getNext();
                }

                afterCurrentNode = currentNode.getNext();
                currentNode.setNext(node);
                afterCurrentNode.setPrevious(node);
                node.setNext(afterCurrentNode);
                node.setPrevious(currentNode);
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
    public Object remove(int index) {
        if (index < size) {
            Node target;
            Node afterTargetNode;

            if (index == 0) {
                target = head;
                head = head.getNext();
                head.setPrevious(null);
                return target.getValue();
            } else {
                Node currentNode = head;

                for (int i = 0; i < index - 1; i++) {
                    currentNode = currentNode.getNext();
                }
                target = currentNode.getNext();
                afterTargetNode = target.getNext();
                currentNode.setNext(target.getNext());
                afterTargetNode.setPrevious(target.getPrevious());

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
        Node currentNode = head;

        while (currentNode.getNext() != null) {

            System.out.println(currentNode.getValue());
            currentNode = currentNode.getNext();
        }
        System.out.println(currentNode.getValue());
    }
}

package com.scalefocus.training.collection.queue;

import com.scalefocus.training.collection.common.BaseNode;
import com.scalefocus.training.collection.common.MyQueue;
import com.scalefocus.training.collection.common.Node;

/**
 * @author Kristiyan SLavov
 */
public class Queue<T> implements MyQueue<T> {

    private BaseNode<T> tail;

    private BaseNode<T> head;

    private int size = 0;

    /**
     * This method inserts the specified element into the queue.
     *
     * @param element - the specified element that will be inserted into the queue.
     */
    public void push(T element) {
        BaseNode<T> node = new BaseNode<>(element);

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
     * This method removes the head of the queue and then returns the new head or return null if the queue is empty.
     *
     * @return - the new head of the queue or null if the queue is empty.
     */
    public T poll() {
        if (head != null) {
            T target = head.getValue();
            if (head.getNext() != null) {
                head = head.getNext();
            } else {
                head = null;
                tail = null;
            }
            --size;
            return target;
        }
        return null;
    }

    /**
     * This method returns the head of the queue or null if the queue is empty.
     *
     * @return - the head of the queue or null if the queue is empty.
     */
    public T peek() {
        return head != null ? head.getValue() : null;
    }

    /**
     * This method returns the size of the queue.
     *
     * @return - the size of the queue.
     */
    public int size() {
        return size;
    }

    /**
     * This method prints all the elements from the queue.
     */
    public void print() {
        Node currentNode = head;

        while (currentNode.getNext() != null) {
            System.out.print(currentNode.getValue() + " ");
            currentNode = currentNode.getNext();
        }
        System.out.print(currentNode.getValue());
    }
}

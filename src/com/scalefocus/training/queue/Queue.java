package com.scalefocus.training.queue;

import com.scalefocus.training.MyList;
import com.scalefocus.training.MyQueue;
import com.scalefocus.training.link.Node;

import java.util.Arrays;

/**
 * @author Kristiyan SLavov
 */
public class Queue implements MyQueue {

    private Node tail;

    private Node head;

    private int size = 0;

    /**
     * This method inserts the specified element into the queue.
     *
     * @param element - the specified element that will be inserted into the queue.
     */
    public void push(Object element) {
        Node node = new Node(element, null);

        if (head == null) {
            head = node;
            tail = node;
        } else {
            Node currentNode = tail;
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
    public Object poll() {
        head = head.getNext();
        --size;

        return head.getValue();
    }

    /**
     * This method returns the head of the queue or null if the queue is empty.
     *
     * @return - the head of the queue or null if the queue is empty.
     */
    public Object peek() {
        return head;
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

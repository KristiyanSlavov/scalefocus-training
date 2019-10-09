package com.scalefocus.training.stack;

import com.scalefocus.training.MyQueue;
import com.scalefocus.training.link.Node;

/**
 * @author Kristiyan SLavov
 */
public class Stack implements MyQueue {

    private Node top;

    private Node theFirst;

    private int size = 0;

    /**
     * This method pushes a specified element onto the top of the stack
     *
     * @param element - the specified element to be pushed onto this stack.
     */
    @Override
    public void push(Object element) {
        Node node = new Node(element, null);

        if (theFirst == null) {
            theFirst = node;
            top = node;
        } else {
            Node currentNode = top;
            currentNode.setNext(node);
            top = node;
        }
        ++size;
    }

    /**
     * This method removes the object at the top of the stack and returns the new top object.
     *
     * @return - the object at the top of the stack.
     */
    @Override
    public Object poll() {
        Node currentNode = theFirst;

        while (currentNode.getNext().getNext() != null) {
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(null);
        top = currentNode;
        --size;
        return top.getValue();
    }

    /**
     * This method returns the object at the top of the stack without removing it.
     *
     * @return - the object at the top of the stack.
     */
    @Override
    public Object peek() {
        return top.getValue();
    }

    /**
     * This method returns the size of the stack.
     *
     * @return - the size of the stack.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * This method prints all the elements from the stack
     */
    @Override
    public void print() {
        Node currentNode = theFirst;

        while (currentNode.getNext() != null) {
            System.out.print(currentNode.getValue() + " ");
            currentNode = currentNode.getNext();
        }
        System.out.print(currentNode.getValue());
    }
}

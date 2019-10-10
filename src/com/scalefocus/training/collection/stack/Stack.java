package com.scalefocus.training.collection.stack;

import com.scalefocus.training.collection.common.MyQueue;
import com.scalefocus.training.collection.common.Node;

/**
 * @author Kristiyan SLavov
 */
public class Stack implements MyQueue {

    private Node top;

    private Node bottom;

    private int size = 0;

    /**
     * This method pushes a specified element onto the top of the stack
     *
     * @param element - the specified element to be pushed onto this stack.
     */
    @Override
    public void push(Object element) {
        Node node = new Node(element);

        if (bottom == null) {
            bottom = node;
            top = node;
        } else {
            node.setNext(top);
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
        if(top != null) {
            Object value = top.getValue();
            if (top.getNext() != null) {
                top = top.getNext();
            } else {
                top = null;
                bottom = null;
            }
            -- size;
            return value;
        }
        return null;
    }

    /**
     * This method returns the object at the top of the stack without removing it.
     *
     * @return - the object at the top of the stack.
     */
    @Override
    public Object peek() {
        return top != null ? top.getValue() : null;
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
        Node currentNode = bottom;

        while (currentNode.getNext() != null) {
            System.out.print(currentNode.getValue() + " ");
            currentNode = currentNode.getNext();
        }
        System.out.print(currentNode.getValue());
    }
}

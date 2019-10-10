package com.scalefocus.training.collection.common;

/**
 * @author Kristiyan SLavov
 */
public interface MyQueue {

    void push(Object element);

    Object poll();

    Object peek();

    int size();

    void print();
}

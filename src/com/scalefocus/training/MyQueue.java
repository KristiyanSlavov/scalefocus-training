package com.scalefocus.training;

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

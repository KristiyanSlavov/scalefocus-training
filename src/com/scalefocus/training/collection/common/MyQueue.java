package com.scalefocus.training.collection.common;

/**
 * @author Kristiyan SLavov
 */
public interface MyQueue<T> {

    void push(T element);

    T poll();

    T peek();

    int size();

    void print();
}

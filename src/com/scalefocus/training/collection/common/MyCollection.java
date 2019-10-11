package com.scalefocus.training.collection.common;

/**
 * @author Kristiyan SLavov
 */
public interface MyCollection<T> {

    T get(int index);

    void add(T data);

    T remove(int index);

    void print();

    int size();
}

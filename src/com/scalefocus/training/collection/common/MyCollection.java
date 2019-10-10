package com.scalefocus.training.collection.common;

/**
 * @author Kristiyan SLavov
 */
public interface MyCollection {

    Object get(int index);

    void add(Object data);

    Object remove(int index);

    void print();

    int size();
}

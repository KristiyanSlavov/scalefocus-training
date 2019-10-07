package com.scalefocus.training;

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

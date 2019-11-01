package com.scalefocus.training.collection.common;

/**
 * @author Kristiyan SLavov
 */
public interface MySet<K> {

    void add(K element);

    boolean remove(K element);

    boolean contains(K element);

    int size();

    boolean isEmpty();
}

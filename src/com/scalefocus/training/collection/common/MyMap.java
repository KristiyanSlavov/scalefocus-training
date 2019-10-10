package com.scalefocus.training.collection.common;

/**
 * @author Kristiyan SLavov
 */
public interface MyMap<K, V> {

    void put(K key, V value);

    V get(K key);

    V remove(K key);

    boolean contains(K key);
}

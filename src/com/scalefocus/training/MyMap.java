package com.scalefocus.training;

/**
 * @author Kristiyan SLavov
 */
public interface MyMap<K, V> {

    void put(K key, V value);

    V get(K key);

    V remove(K key);

    boolean contains(K key);
}

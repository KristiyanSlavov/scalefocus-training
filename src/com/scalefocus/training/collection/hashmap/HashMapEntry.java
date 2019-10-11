package com.scalefocus.training.collection.hashmap;

import java.util.Objects;

/**
 * @author Kristiyan SLavov
 */
public class HashMapEntry<K, V> {

    private K key;

    private V value;

    private HashMapEntry<K, V> next;

    public HashMapEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashMapEntry<?, ?> that = (HashMapEntry<?, ?>) o;
        return Objects.equals(key, that.key) &&
                Objects.equals(value, that.value) &&
                Objects.equals(next, that.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value, next);
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public HashMapEntry<K, V> getNext() {
        return next;
    }

    public void setNext(HashMapEntry<K, V> next) {
        this.next = next;
    }

}

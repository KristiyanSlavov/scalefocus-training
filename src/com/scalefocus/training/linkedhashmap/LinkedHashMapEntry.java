package com.scalefocus.training.linkedhashmap;

import java.util.Objects;

/**
 * @author Kristiyan SLavov
 */
public class LinkedHashMapEntry<K,V> {
    private K key;
    private V value;
    private LinkedHashMapEntry<K,V> next, before, after;

    public LinkedHashMapEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedHashMapEntry<?, ?> that = (LinkedHashMapEntry<?, ?>) o;
        return Objects.equals(key, that.key) &&
                Objects.equals(value, that.value) &&
                Objects.equals(next, that.next) &&
                Objects.equals(before, that.before) &&
                Objects.equals(after, that.after);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value, next, before, after);
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

    public LinkedHashMapEntry<K, V> getNext() {
        return next;
    }

    public void setNext(LinkedHashMapEntry<K, V> next) {
        this.next = next;
    }

    public LinkedHashMapEntry<K, V> getBefore() {
        return before;
    }

    public void setBefore(LinkedHashMapEntry<K, V> before) {
        this.before = before;
    }

    public LinkedHashMapEntry<K, V> getAfter() {
        return after;
    }

    public void setAfter(LinkedHashMapEntry<K, V> after) {
        this.after = after;
    }
}

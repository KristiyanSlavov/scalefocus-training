package com.scalefocus.training.collection.common;

public class Node<V, T extends Node<V,T>> {

    private V value;

    private T next;

    public Node(V value) {
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public T getNext() {
        return next;
    }

    public void setNext(T next) {
        this.next = next;
    }

}

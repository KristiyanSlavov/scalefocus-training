package com.scalefocus.training.collection.common;

import java.util.Objects;

/**
 * @author Kristiyan SLavov
 */
public class RBNode<K, V> {

    private K key;

    private V value;

    private Color color;

    private RBNode<K, V> parent;

    private RBNode<K, V> leftChild;

    private RBNode<K, V> rightChild;

    public RBNode() {
    }

    public RBNode(K key, V value, Color color) {
        this.key = key;
        this.value = value;
        this.color = color;
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public RBNode<K, V> getParent() {
        return parent;
    }

    public void setParent(RBNode<K, V> parent) {
        this.parent = parent;
    }

    public RBNode<K, V> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(RBNode<K, V> leftChild) {
        this.leftChild = leftChild;
    }

    public RBNode<K, V> getRightChild() {
        return rightChild;
    }

    public void setRightChild(RBNode<K, V> rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RBNode<?, ?> rbNode = (RBNode<?, ?>) o;
        return Objects.equals(key, rbNode.key) &&
                Objects.equals(value, rbNode.value) &&
                color == rbNode.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value, color);
    }
}

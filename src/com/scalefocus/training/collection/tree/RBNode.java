package com.scalefocus.training.collection.tree;

import java.util.Objects;

/**
 * @author Kristiyan SLavov
 */
public class RBNode<V> {

    private String color;

    private RBNode<V> parent;

    private RBNode<V> leftChild;

    private RBNode<V> rightChild;

    private final V value;

    public RBNode(V value, String color) {
        this.value = value;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public RBNode<V> getParent() {
        return parent;
    }

    public void setParent(RBNode<V> parent) {
        this.parent = parent;
    }

    public RBNode<V> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(RBNode<V> leftChild) {
        this.leftChild = leftChild;
    }

    public RBNode<V> getRightChild() {
        return rightChild;
    }

    public void setRightChild(RBNode<V> rightChild) {
        this.rightChild = rightChild;
    }

    public V getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RBNode<?> rbNode = (RBNode<?>) o;
        return color.equals(rbNode.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color);
    }
}

package com.scalefocus.training.collection.tree;

import java.util.Objects;

/**
 * @author Kristiyan SLavov
 */
public class RBNode<V> {

    private V value;

    private String color;

    private RBNode<V> parent;

    private RBNode<V> leftChild;

    private RBNode<V> rightChild;

    public RBNode() {}

    public RBNode(V value, String color) {
        this.value = value;
        this.color = color;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RBNode<?> rbNode = (RBNode<?>) o;
        return Objects.equals(value, rbNode.value) &&
                Objects.equals(color, rbNode.color) &&
                Objects.equals(parent, rbNode.parent) &&
                Objects.equals(leftChild, rbNode.leftChild) &&
                Objects.equals(rightChild, rbNode.rightChild);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, color, parent, leftChild, rightChild);
    }
}

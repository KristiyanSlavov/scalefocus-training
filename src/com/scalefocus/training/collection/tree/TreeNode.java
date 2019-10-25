package com.scalefocus.training.collection.tree;

import java.util.Objects;

/**
 * @author Kristiyan SLavov
 */
public class TreeNode<V, T> {

    private final V value;

    private T leftChild;

    private T rightChild;

    private T parent;

    public TreeNode(V value) {
        this.value = value;
    }

    public boolean isComplete() {
        return leftChild != null & rightChild != null;
    }

    public V getValue() {
        return value;
    }

    public T getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(T leftChild) {
        this.leftChild = leftChild;
    }

    public T getRightChild() {
        return rightChild;
    }

    public void setRightChild(T rightChild) {
        this.rightChild = rightChild;
    }

    public T getParent() {
        return parent;
    }

    public void setParent(T parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode<?, ?> treeNode = (TreeNode<?, ?>) o;
        return Objects.equals(value, treeNode.value) &&
                Objects.equals(leftChild, treeNode.leftChild) &&
                Objects.equals(rightChild, treeNode.rightChild) &&
                Objects.equals(parent, treeNode.parent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, leftChild, rightChild, parent);
    }
}

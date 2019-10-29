package com.scalefocus.training.collection.common;

import java.util.Objects;

/**
 * @author Kristiyan SLavov
 */
public class TreeNode<V> {

    private V value;

    private TreeNode<V> leftChild;

    private TreeNode<V> rightChild;

    public TreeNode() {}

    public TreeNode(V value) {
        this.value = value;
    }

    public boolean isComplete() {
        return leftChild != null & rightChild != null;
    }

    public V getValue() {
        return value;
    }

    public TreeNode<V> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode<V> leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode<V> getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode<V> rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode<?> treeNode = (TreeNode<?>) o;
        return value.equals(treeNode.value) &&
                leftChild.equals(treeNode.leftChild) &&
                rightChild.equals(treeNode.rightChild);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, leftChild, rightChild);
    }
}

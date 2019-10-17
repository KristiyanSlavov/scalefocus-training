package com.scalefocus.training.collection.tree;

/**
 * @author Kristiyan SLavov
 */
public class TreeNode<T> {

    private T key;

    private TreeNode<T> leftChild;

    private TreeNode<T> rightChild;

    public TreeNode(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public TreeNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }
}

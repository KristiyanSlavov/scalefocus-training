package com.scalefocus.training.collection.tree;

import com.scalefocus.training.collection.common.TreeNode;

/**
 * @author Kristiyan SLavov
 */
public class BinarySearchTree<V extends Comparable<V>> {

    private TreeNode<V> root;

    public TreeNode<V> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<V> root) {
        this.root = root;
    }

    /**
     * This method adds new node to the tree and find the position at which the new node will be placed.
     * If the value of the new node is less than it's parent's value then the new node's position
     * will be to the left of its parent, else it will be to the right of its parent.
     *
     * @param value - the value of the new node
     * @return - the new added node
     */
    public TreeNode<V> add(V value) {
        TreeNode<V> newNode = new TreeNode<>(value);


        if (root == null) {
            root = newNode;

        } else {
            TreeNode<V> currentNode = root;
            TreeNode<V> parent;

            while (true) {
                parent = currentNode;
                if (newNode.getValue().compareTo(currentNode.getValue()) < 0) {
                    currentNode = currentNode.getLeftChild();
                    if (currentNode == null) {
                        parent.setLeftChild(newNode);
                        return newNode;
                    }
                } else {
                    currentNode = currentNode.getRightChild();
                    if (currentNode == null) {
                        parent.setRightChild(newNode);
                        return newNode;
                    }
                }
            }
        }
        return newNode;
    }

    /**
     * The method search and returns a specified node from the BinarySearchTree.
     *
     * @param root  - the root of the tree
     * @param value - the value of the specified node
     * @return - the specified node
     */
    public TreeNode<V> search(TreeNode<V> root, V value) {
        if (root == null || root.getValue().equals(value)) {
            return root;
        }
        if (root.getValue().compareTo(value) > 0) {
            return search(root.getLeftChild(), value);
        }
        return search(root.getRightChild(), value);
    }
}

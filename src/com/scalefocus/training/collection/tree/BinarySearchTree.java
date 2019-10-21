package com.scalefocus.training.collection.tree;

/**
 * @author Kristiyan SLavov
 */
public class BinarySearchTree<T extends Comparable<T>> {

    private TreeNode<T> root;

    public TreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<T> root) {
        this.root = root;
    }

    /**
     * This method adds new node to the tree and find the position at which the new node will be placed.
     * If the value of the new node is less than it's parent's value then the new node's position
     * will be to the left of its parent, else it will be to the right of its parent.
     *
     * @param key - the value of the new node
     */
    public void add(T key) {
        TreeNode<T> newNode = new TreeNode<>(key);

        if (root == null) {
            root = newNode;

        } else {
            TreeNode<T> currentNode = root;
            TreeNode<T> parent;

            while (true) {
                parent = currentNode;

                if (key.compareTo(currentNode.getValue()) < 0) {
                    currentNode = currentNode.getLeftChild();
                    if (currentNode == null) {
                        parent.setLeftChild(newNode);
                        return;
                    }
                } else {
                    currentNode = currentNode.getRightChild();
                    if (currentNode == null) {
                        parent.setRightChild(newNode);
                        return;
                    }
                }
            }
        }
    }

    public TreeNode<T> search(TreeNode<T> root, T value) {
        if (root == null || root.getValue().equals(value)) {
            return root;
        }
        if (root.getValue().compareTo(value) > 0) {
            return search(root.getLeftChild(), value);
        }
        return search(root.getRightChild(), value);
    }
}

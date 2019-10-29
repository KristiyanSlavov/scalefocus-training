package com.scalefocus.training.collection.tree;

import com.scalefocus.training.collection.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Kristiyan SLavov
 */
public class BinaryTree<T> {

    private TreeNode<T> root;

    private Queue<TreeNode<T>> queue = new LinkedList<>();

    /**
     * This method, using a insert method, pushes new node into the queue
     * through which the binary tree is implemented.
     *
     * @param value - the value of the new node
     */
    public void push(T value) {
        TreeNode<T> node = new TreeNode<>(value);
        if (root == null) {
            root = node;
            queue.add(root);
        } else {
            insert(queue.peek(), node);
        }
    }

    /**
     * This method adds new node to the binary tree.
     *
     * @param root - the root node of the binary tree
     * @param node - the new node to be inserted
     */
    private void insert(TreeNode<T> root, TreeNode<T> node) {
        if (root.isComplete()) {
            queue.poll();
            insert(queue.peek(), node);
            return;
        }

        if (root.getLeftChild() == null) {
            root.setLeftChild(node);
            queue.add(node);
        } else {
            root.setRightChild(node);
            queue.add(node);
        }
    }

    /**
     * This method prints all the elements from the binary tree using printHelper method.
     */
    public void print() {
        printHelper(root, "");
    }

    /**
     * This method prints all the binary tree's elements through DepthFirstSearch(preOrder) algorithm
     *
     * @param root - the root node of the binary tree
     * @param step -
     */
    private void printHelper(TreeNode<T> root, String step) {
        if (root != null) {
            System.out.println(step + root.getValue());
            printHelper(root.getLeftChild(), step + "  ");
            printHelper(root.getRightChild(), step + "  ");
        }
    }
}

package com.scalefocus.training.algorithm.search;

import com.scalefocus.training.collection.common.TreeNode;
import com.scalefocus.training.collection.stack.Stack;

/**
 * @author Kristiyan SLavov
 */
public class DepthFirstSearch<T extends Comparable<T>> {

    /**
     * This method traverses the tree through Depth-first search(inorder) using recursion.
     *
     * @param node - the roof node
     */
    public void inOrderTraverse(TreeNode<T> node) {
        if (node != null) {
            inOrderTraverse(node.getLeftChild());
            System.out.println(node.getValue());
            inOrderTraverse(node.getRightChild());
        }
    }

    /**
     * This method traverses the tree through Depth-first search(preorder) using recursion.
     *
     * @param node - the roof node
     */
    public void preOrderTraverse(TreeNode<T> node) {
        if (node != null) {
            System.out.println(node.getValue());
            preOrderTraverse(node.getLeftChild());
            preOrderTraverse(node.getRightChild());
        }
    }

    /**
     * This method traverses the tree through Depth-first search(postorder) using recursion.
     *
     * @param node - the roof node
     */
    public void postOrderTraverse(TreeNode<T> node) {
        if (node != null) {
            postOrderTraverse(node.getLeftChild());
            postOrderTraverse(node.getRightChild());
            System.out.println(node.getValue());
        }
    }

    /**
     * This method traverses the tree through Depth-first search algorithm using stack.
     * @param root - the root of the tree
     * @param value - the value of the specified node
     * @return - the searched node
     */
    public TreeNode<T> search(TreeNode<T> root, T value) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode<T>> stack = new Stack<>();
        TreeNode<T> target = null;
        stack.push(root);

        while (stack.size() != 0) {
            TreeNode<T> currentNode = stack.poll();
            if (currentNode.getValue().equals(value)) {
                target = currentNode;
                return target;
            }
            if (currentNode.getRightChild() != null) {
                stack.push(currentNode.getRightChild());
            }
            if (currentNode.getLeftChild() != null) {
                stack.push(currentNode.getLeftChild());
            }
        }
        return null;
    }
}

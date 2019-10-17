package com.scalefocus.training.collection.tree;

import com.scalefocus.training.collection.queue.Queue;
import com.scalefocus.training.collection.stack.Stack;

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

                if (key.compareTo(currentNode.getKey()) < 0) {
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

    /**
     * This method traverses the tree through Depth-first search(inorder) using recursion.
     *
     * @param node - the roof node
     */
    public void inOrderTraverse(TreeNode<T> node) {
        if (node != null) {
            inOrderTraverse(node.getLeftChild());
            System.out.println(node.getKey());
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
            System.out.println(node.getKey());
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
            System.out.println(node.getKey());
        }
    }

    //    public String findNode(T key) {
    //        TreeNode currentNode = root;
    //
    //        while (currentNode.getKey() != key) {
    //            if (key < currentNode.getKey()) {
    //                currentNode = currentNode.getLeftChild();
    //            } else {
    //                currentNode = currentNode.getRightChild();
    //            }
    //            if (currentNode == null) {
    //                return null;
    //            }
    //        }
    //        return currentNode.getName();
    //    }

    /**
     * This method traverses the tree through Breadth-first search using queue.
     */
    public void breadthFirstSearch() {
        Queue<TreeNode<T>> queue = new Queue<>();
        queue.push(root);
        while (queue.size() != 0) {
            TreeNode<T> currentNode = queue.poll();
            System.out.println(currentNode.getKey());
            if (currentNode.getLeftChild() != null) {
                queue.push(currentNode.getLeftChild());
            }
            if (currentNode.getRightChild() != null) {
                queue.push(currentNode.getRightChild());
            }
        }
    }

    /**
     * This method traverses the tree through Depth-first search using stack.
     */
    public void depthFirstSearch() {
        if (root == null) {
            return;
        }

        Stack<TreeNode<T>> stack = new Stack<>();
        stack.push(root);
        while (stack.size() != 0) {
            TreeNode<T> currentNode = stack.poll();
            System.out.println(currentNode.getKey());
            if (currentNode.getRightChild() != null) {
                stack.push(currentNode.getRightChild());
            }
            if (currentNode.getLeftChild() != null) {
                stack.push(currentNode.getLeftChild());
            }
        }
    }
}

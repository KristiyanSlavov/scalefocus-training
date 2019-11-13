package com.scalefocus.training.algorithm.search;

import com.scalefocus.training.collection.common.TreeNode;
import com.scalefocus.training.collection.queue.Queue;

/**
 * @author Kristiyan SLavov
 */
public class BreadthFirstSearch<T> {

    /**
     * This method traverses the tree through Breadth-first search algorithm using queue.
     * @param root - the root of the tree
     * @param value - the value of the specified node
     * @return - the searched node
     */
    public TreeNode<T> search(TreeNode<T> root, T value) {
        Queue<TreeNode<T>> queue = new Queue<>();
        TreeNode<T> target;
        queue.push(root);

        while (queue.size() != 0) {
            TreeNode<T> currentNode = queue.poll();
            if (currentNode.getValue().equals(value)) {
                target = currentNode;
                return target;
            }
            if (currentNode.getLeftChild() != null) {
                queue.push(currentNode.getLeftChild());
            }
            if (currentNode.getRightChild() != null) {
                queue.push(currentNode.getRightChild());
            }
        }
        return null;
    }
}

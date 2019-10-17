package com.scalefocus.training;

import com.scalefocus.training.collection.queue.Queue;
import com.scalefocus.training.collection.tree.BinarySearchTree;
import com.scalefocus.training.collection.tree.BinaryTree;
import com.scalefocus.training.collection.tree.TreeNode;

public class TrainingApp {

    public static void main(String[] args) {
        BinarySearchTree<Integer> binaryTree = new BinarySearchTree<>();
        binaryTree.setRoot(new TreeNode<Integer>(1));
        binaryTree.getRoot().setLeftChild(new TreeNode<Integer>(2));
        binaryTree.getRoot().setRightChild(new TreeNode<Integer>(3));
        binaryTree.getRoot().getLeftChild().setLeftChild(new TreeNode<Integer>(4));
        binaryTree.getRoot().getLeftChild().setRightChild(new TreeNode<Integer>(5));
        binaryTree.getRoot().getRightChild().setLeftChild(new TreeNode<Integer>(6));
        binaryTree.getRoot().getRightChild().setRightChild(new TreeNode<Integer>(7));
        binaryTree.breadthFirstSearch();
    }
}


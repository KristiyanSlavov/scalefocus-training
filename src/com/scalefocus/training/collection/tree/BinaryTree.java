package com.scalefocus.training.collection.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * @author Kristiyan SLavov
 */
public class BinaryTree<T> {

//    private TreeNode<T> root;
//
//    private Queue<TreeNode<T>> queue = new LinkedList<>();
//
//    public void push(T value) {
//        TreeNode<T> node = new TreeNode<>(value);
//        if (root == null) {
//            root = node;
//            queue.add(root);
//        } else {
//            insert(queue.peek(), node);
//        }
//    }
//
//    private void insert(TreeNode<T> root, TreeNode<T> node) {
//        if (root.isComplete()) {
//            queue.poll();
//            insert(queue.peek(), node);
//            return;
//        }
//
//        if (root.getLeftChild() == null) {
//            root.setLeftChild(node);
//            queue.add(node);
//        } else {
//            root.setRightChild(node);
//            queue.add(node);
//        }
//    }
//
//    public void print() {
//        print(root, "");
//    }
//
//    private void print(TreeNode<T> root, String step) {
//        if (root != null) {
//            System.out.println(step + root.getValue());
//            print(root.getLeftChild(), step + "  ");
//            print(root.getRightChild(), step + "  ");
//        }
//    }
}

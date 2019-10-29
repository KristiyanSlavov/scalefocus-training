package com.scalefocus.training;

import com.scalefocus.training.collection.array.MyArrayList;
import com.scalefocus.training.collection.tree.BinarySearchTree;
import com.scalefocus.training.collection.tree.BinaryTree;
import com.scalefocus.training.collection.tree.RedBlackTree;

import java.util.TreeSet;
import java.util.stream.IntStream;

public class TrainingApp {

    public static void main(String[] args) {
        RedBlackTree<Integer> redBlackTree = new RedBlackTree<>();
        redBlackTree.insert(5);
        redBlackTree.insert(15);
        redBlackTree.insert(25);
        redBlackTree.insert(35);
        redBlackTree.insert(45);
        redBlackTree.insert(55);
        redBlackTree.insert(65);
        redBlackTree.insert(75);
        redBlackTree.delete(35);
        redBlackTree.print();

    }
}

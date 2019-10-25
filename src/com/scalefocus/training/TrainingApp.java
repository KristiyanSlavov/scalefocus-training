package com.scalefocus.training;

import com.scalefocus.training.collection.tree.RedBlackTree;

import java.util.stream.IntStream;

public class TrainingApp {

    public static void main(String[] args) {
        RedBlackTree<Integer> redBlackTree = new RedBlackTree<>();
        for (int i = 1; i <= 9; i++) {
            redBlackTree.insert(i);
        }
        redBlackTree.print();
    }
}

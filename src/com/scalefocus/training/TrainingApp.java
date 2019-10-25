package com.scalefocus.training;

import com.scalefocus.training.collection.tree.RBNode;
import com.scalefocus.training.collection.tree.RedBlackTree;
import com.scalefocus.training.collection.tree.TreeNode;

public class TrainingApp {

    public static void main(String[] args) {
        RedBlackTree<Integer> redBlackTree = new RedBlackTree<>();
//        redBlackTree.insert(23);
//        redBlackTree.insert(10);
//        redBlackTree.insert(33);
//        redBlackTree.insert(3);
//        redBlackTree.insert(5);
//        redBlackTree.insert(30);
//        redBlackTree.insert(35);

        redBlackTree.insert(10);
        redBlackTree.insert(1);
        redBlackTree.insert(2);
        redBlackTree.insert(5);
        redBlackTree.insert(6);
        redBlackTree.insert(70);
        redBlackTree.insert(55);
        redBlackTree.insert(29);
        redBlackTree.insert(31);
        redBlackTree.insert(15);
        redBlackTree.insert(11);
        redBlackTree.insert(17);
        redBlackTree.insert(33);
        redBlackTree.insert(34);
//        redBlackTree.delete(33);
        redBlackTree.print();

    }
}

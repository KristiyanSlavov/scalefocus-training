package com.scalefocus.training.collection.treeset;

import com.scalefocus.training.collection.tree.RedBlackTree;

/**
 * @author Kristiyan SLavov
 */
public class MyTreeSet<V extends Comparable<V>> {

    private RedBlackTree<V> redBlackTree;

    public MyTreeSet() {
        redBlackTree = new RedBlackTree<>();
    }

    public void add(V value) {
        redBlackTree.insert(value);
    }

    public boolean contains(V value) {
        return redBlackTree.contains(value);
    }

    public Object first() {
        return redBlackTree.first();
    }

    public Object last() {
        return redBlackTree.last();
    }

    public boolean isEmpty() {
        return redBlackTree.isEmpty();
    }

    public int size() {
        return redBlackTree.size();
    }

    public void print() {
        redBlackTree.print();
    }
}

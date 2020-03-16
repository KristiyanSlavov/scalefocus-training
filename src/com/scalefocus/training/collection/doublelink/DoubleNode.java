package com.scalefocus.training.collection.doublelink;

import com.scalefocus.training.collection.common.Node;

/**
 * @author Kristiyan SLavov
 */
public class DoubleNode<K> extends Node<K, DoubleNode<K>> {

    private DoubleNode<K> previous;

    DoubleNode(K value) {
        super(value);
    }

    public DoubleNode<K> getPrevious() {
        return previous;
    }

    public void setPrevious(DoubleNode<K> previous) {
        this.previous = previous;
    }

}
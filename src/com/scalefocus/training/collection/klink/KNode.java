package com.scalefocus.training.collection.klink;

import com.scalefocus.training.collection.common.Node;

/**
 * @author Kristiyan SLavov
 */
public class KNode<E> extends Node<E, KNode<E>> {

    private KNode<E> kLink;

    public KNode(E value) {
        super(value);
    }

    public KNode<E> getkLink() {
        return kLink;
    }

    public void setkLink(KNode<E> kLink) {
        this.kLink = kLink;
    }
}

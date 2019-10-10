package com.scalefocus.training.collection.klink;

/**
 * @author Kristiyan SLavov
 */
public class KNode {

    private Object value;

    private KNode next;

    private KNode kLink;

    public KNode(Object value) {
        this.value = value;
    }

    public KNode getkLink() {
        return kLink;
    }

    public void setkLink(KNode kLink) {
        this.kLink = kLink;
    }
    public Object getValue() {
        return value;
    }

    public void setNext(KNode next) {
        this.next = next;
    }

    public KNode getNext() {
        return next;
    }

}

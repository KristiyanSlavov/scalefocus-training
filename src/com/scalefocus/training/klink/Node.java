package com.scalefocus.training.klink;

/**
 * @author Kristiyan SLavov
 */
public class Node {

    private Object value;

    private Node next;

    private Node kLink;

    Node(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getkLink() {
        return kLink;
    }

    public void setkLink(Node kLink) {
        this.kLink = kLink;
    }
}

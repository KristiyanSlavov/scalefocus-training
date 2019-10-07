package com.scalefocus.training.klink;

import com.scalefocus.training.MyCollection;
import com.scalefocus.training.MyList;

import java.util.Collection;
import java.util.Objects;

/**
 * @author Kristiyan SLavov
 */
public class MyKLinkedList implements MyCollection {

    private Node head;

    private Node tail;

    private int size = 0;

    private final int k;

    private Node kNode;

    public MyKLinkedList(int k) {
        if (k > 1) {
            this.k = k;
        } else {
            throw new IllegalArgumentException("K must be bigger than 1!");
        }
    }

    /**
     * This method gets the element on specified position.
     * If position is larger than the size of the list an {@link IndexOutOfBoundsException} will be thrown.
     *
     * @param position - the position from where an element will be got
     * @return the element that had been got
     */
    @Override
    public Object get(int position) {
        Node target;
        Node currentNode;
        if (position >= 1 && position <= size) {

            if (position == 1) {
                target = head;
                System.out.println(target.getValue());
                return target.getValue();
            }

            currentNode = head;
            for (int i = 1; i < position; i++) {
                System.out.println("iteration:" + i);
                if (currentNode.getkLink() != null) {
                    if (i + k <= position) {
                        currentNode = currentNode.getkLink();
                        if (i + k == position) {
                            break;
                        } else {
                            i += k - 1;
                            continue;
                        }
                    }
                }
                currentNode = currentNode.getNext();
            }
            target = currentNode;
            System.out.println(target.getValue());
            return target.getValue();

        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * This method adds an element in the list.
     *
     * @param data - the value that will be stored in the list
     */
    @Override
    public void add(Object data) {
        Node node = new Node(data);

        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
        ++size;

        setKNodes(node, size);
    }

    /**
     * This method removes the element on specified position.
     * If position is larger than the size of the list an {@link IndexOutOfBoundsException} will be thrown.
     *
     * @param position - the position where an element will be removed
     * @return the element that had been removed
     */
    @Override
    public Object remove(int position) {
        Node removed = null;
        Node current = head;

        if (position >= 1 && position <= size) {

            if (position == 1) {
                removed = head;
                head = head.getNext();
                current = head;
                size--;

                for (int i = 1; i < size; i++) {
                    current.setkLink(null);
                    setKNodes(current, i);
                    current = current.getNext();
                }
                return removed;
            }
            for (int i = 1; i <= size; i++) {
                current.setkLink(null);
                setKNodes(current, i);

                if (position == i + 1) {
                    removed = current.getNext();
                    current.setNext(current.getNext().getNext());
                    size--;
                    if (tail == removed) {
                        tail = current;
                    }
                }
                current = current.getNext();
            }
            return removed;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * This method sets KNode and links between all KNodes.
     *
     * @param currentNode - the starting node
     * @param position    - the position of the starting node
     */
    private void setKNodes(Node currentNode, int position) {
        if (position % k == 0) {
            if (position == k) {
                kNode = currentNode;
            } else if (kNode != null) {
                kNode.setkLink(currentNode);
                kNode = currentNode;
            }
        }
    }

    /**
     * This method prints all elements from the list.
     */
    @Override
    public void print() {
        Node cur = head;
        while (cur != null) {
            System.out.println(cur + "::" + cur.getValue() + " -> " + cur.getkLink());
            cur = cur.getNext();
        }
    }

    public int size() {
        return size;
    }
}

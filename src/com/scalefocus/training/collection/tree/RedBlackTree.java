package com.scalefocus.training.collection.tree;

import com.scalefocus.training.collection.common.Color;
import com.scalefocus.training.collection.common.RBNode;

import java.util.NoSuchElementException;

/**
 * @author Kristiyan SLavov
 */
public class RedBlackTree<V extends Comparable<V>> {

    private RBNode<V> root;

    private RBNode<V> TNULL;

    private RBNode<V> last;

    private RBNode<V> first;

    private int size = 0;

    public RedBlackTree() {
        TNULL = new RBNode<>();
        TNULL.setColor(Color.BLACK);
        root = TNULL;
    }

    /**
     * This method inserts added new node to the RedBlack tree.The new node has a "RED" color
     * and a specified value and its position is determined by its root. If the root is empty,
     * the new node becomes the root of the RedBlack tree. After insertion, fixInsert method
     * is used to rebalanced the RedBlack tree.
     *
     * @param value - the value of the new node
     */
    public void insert(V value) {
        RBNode<V> node = new RBNode<>(value, Color.RED);
        node.setParent(null);
        node.setLeftChild(TNULL);
        node.setRightChild(TNULL);

        RBNode<V> y = null;
        RBNode<V> x = this.root;
        while (x != TNULL) {
            y = x;
            if(node.getValue().compareTo(x.getValue()) == 0) {
                return;
            }
            if (node.getValue().compareTo(x.getValue()) < 0) {
                x = x.getLeftChild();
            } else {
                x = x.getRightChild();
            }
        }
        node.setParent(y);
        if (y == null) {
            root = node;
            first = node;
        } else if (node.getValue().compareTo(y.getValue()) < 0) {
            y.setLeftChild(node);
        } else {
            y.setRightChild(node);
        }
        last = node;
        size++;
        if (node.getParent() == null) {
            node.setColor(Color.BLACK);
            return;
        }
        if (node.getParent().getParent() == null) {
            return;
        }
        fixInsert(node);
    }

    /**
     * This method rebalanced the RedBlack tree after insertion, using a few main cases(+ additional mirror cases).
     * 1 case: The parent and the uncle of the new node are "RED" nodes.
     * 2 case: The parent of the new node is "RED" node and the uncle of the new node is "BLACK" node and:
     * 2.1 case - The parent is right child of the grandparent and the new node is right child of the parent.
     * 2.2 case - The parent is right child of the grandparent and the new node is left child of the parent.
     * 2.3 case - The parent is left child of the grandparent and the new node is left child of the parent.
     * 2.4 case - The parent is left child of the grandparent and the new node is right child of the parent.
     *
     * @param newNode - the new added node
     */
    private void fixInsert(RBNode<V> newNode) {
        RBNode<V> uncle;
        while (Color.RED.equals(newNode.getParent().getColor())) {
            if (newNode.getParent().equals(newNode.getParent().getParent().getRightChild())) {
                uncle = newNode.getParent().getParent().getLeftChild();

                if (Color.RED.equals(uncle.getColor())) {
                    //case 3.1
                    uncle.setColor(Color.BLACK);
                    newNode.getParent().setColor(Color.BLACK);
                    newNode.getParent().getParent().setColor(Color.RED);
                    newNode = newNode.getParent().getParent();
                } else {
                    if (newNode.equals(newNode.getParent().getLeftChild())) {
                        //case 3.2.2
                        newNode = newNode.getParent();
                        rightRotate(newNode);
                    }
                    //case 3.2.1
                    newNode.getParent().setColor(Color.BLACK);
                    newNode.getParent().getParent().setColor(Color.RED);
                    leftRotate(newNode.getParent().getParent());
                }
            } else {
                uncle = newNode.getParent().getParent().getRightChild();

                if (Color.RED.equals(uncle.getColor())) {
                    //case 3.1
                    uncle.setColor(Color.BLACK);
                    newNode.getParent().setColor(Color.BLACK);
                    newNode.getParent().getParent().setColor(Color.RED);
                    newNode = newNode.getParent().getParent();
                } else {
                    if (newNode.equals(newNode.getParent().getRightChild())) {
                        //mirror case 3.2.2
                        newNode = newNode.getParent();
                        leftRotate(newNode);
                    }
                    //mirror case 3.2.1
                    newNode.getParent().setColor(Color.BLACK);
                    newNode.getParent().getParent().setColor(Color.RED);
                    rightRotate(newNode.getParent().getParent());
                }
            }
            if (newNode.equals(root)) {
                break;
            }
        }
        root.setColor(Color.BLACK);
    }

    /**
     * This method makes the node goes down in the left direction and as a result, its right child goes up.
     *
     * @param node - the node to be left-rotate
     */
    private void leftRotate(RBNode<V> node) {
        RBNode<V> y = node.getRightChild();
        node.setRightChild(y.getLeftChild());

        if (y.getLeftChild().equals(TNULL)) {
            y.getLeftChild().setParent(node);
        }
        y.setParent(node.getParent());

        if (node.getParent() == null) {
            this.root = y;
        } else if (node == node.getParent().getLeftChild()) {
            node.getParent().setLeftChild(y);
        } else {
            node.getParent().setRightChild(y);
        }
        y.setLeftChild(node);
        node.setParent(y);
    }

    /**
     * This method makes the node goes down in the right direction and as a result, its left child goes up.
     *
     * @param node - the node to be right-rotate
     */
    private void rightRotate(RBNode<V> node) {
        RBNode<V> y = node.getLeftChild();
        node.setLeftChild(y.getRightChild());
        if (y.getRightChild() != TNULL) {
            y.getRightChild().setParent(node);
        }
        y.setParent(node.getParent());

        if (node.getParent() == null) {
            this.root = y;
        } else if (node == node.getParent().getRightChild()) {
            node.getParent().setRightChild(y);
        } else {
            node.getParent().setLeftChild(y);
        }
        y.setRightChild(node);
        node.setParent(y);
    }

    /**
     * This method deletes a node from the RedBlack tree and then
     * rebalanced the tree using deleteNodeHelper method.
     *
     * @param value - the value of the node to be deleted
     */
    public void delete(V value) {
        deleteNodeHelper(this.root, value);
    }

    /**
     * This method removes a specified node from the RedBlack tree using
     * TRANSPLANT algorithm to replace the node to be deleted. After deletion,
     * the method use a fixDelete method to rebalanced the RedBlack tree.
     *
     * @param node  - the root of the RedBlack tree
     * @param value - the value of the node to be deleted
     */
    private void deleteNodeHelper(RBNode<V> node, V value) {
        //find the node, containing that value
        RBNode<V> deletedNode = TNULL;
        RBNode<V> x, y;

        while (!node.equals(TNULL)) {
            if (value.equals(node.getValue())) {
                deletedNode = node;
            }

            if (value.compareTo(node.getValue()) >= 0) {
                node = node.getRightChild();
            } else {
                node = node.getLeftChild();
            }
        }

        //couldn't find node with this value in the tree
        if (deletedNode.equals(TNULL)) {
            return;
        }
        y = deletedNode;
        Color yOriginalColor = y.getColor();

        if (deletedNode.getLeftChild().equals(TNULL)) {
            x = deletedNode.getRightChild();
            rbTransplant(deletedNode, deletedNode.getRightChild());

        } else if (deletedNode.getRightChild().equals(TNULL)) {
            x = deletedNode.getLeftChild();
            rbTransplant(deletedNode, deletedNode.getLeftChild());

        } else {
            y = minimum(deletedNode.getRightChild());
            yOriginalColor = y.getColor();
            x = y.getRightChild();

            //if minimum right node is the direct child of deleted node
            if (y.getParent().equals(deletedNode)) {
                x.setParent(y);
            } else {
                //else first transplant right of "y" to "y"
                rbTransplant(y, y.getRightChild());
                //right subtree of deleted note become right subtree of y node
                y.setRightChild(deletedNode.getRightChild());
                (y.getRightChild()).setParent(y);
            }

            rbTransplant(deletedNode, y);
            y.setLeftChild(deletedNode.getLeftChild());
            y.getLeftChild().setParent(y);
            y.setColor(deletedNode.getColor());
        }
        if (Color.BLACK.equals(yOriginalColor)) {
            fixDelete(x);
        }
    }

    /**
     * This method rebalanced the RedBlack tree after deletion, using a few main cases(+ additional mirror cases).
     * 1 case: The node to be deleted is "BLACK" node and:
     * 1.1 case: The node's sibling is "RED" node
     * 1.2 case: The node's sibling is a "BLACK" node and both of sibling's children are "BLACK" node too.
     * 1.3. case: The node's sibling is a "BLACK" node, sibling's left child is "RED" node
     * and it's right child is a "BLACK" node.
     * 1.4 case: The node's sibling is a "BLACK" node and sibling's right child is "RED" node.
     *
     * @param node - the deleted node
     */
    private void fixDelete(RBNode<V> node) {
        RBNode<V> sibling = null;

        while (!root.equals(node) && Color.BLACK.equals(node.getColor())) {
            if (node.equals(node.getParent().getLeftChild())) {
                sibling = node.getParent().getRightChild();

                if (Color.RED.equals(sibling.getColor())) {
                    //case 3.1
                    sibling.setColor(Color.BLACK);
                    node.getParent().setColor(Color.RED);
                    leftRotate(node.getParent());
                    sibling = node.getRightChild().getRightChild();
                }
                if (Color.BLACK.equals((sibling.getLeftChild()).getColor())
                        && Color.BLACK.equals((sibling.getRightChild()).getColor())) {
                    //case 3.2
                    sibling.setColor(Color.RED);
                    node = node.getParent();
                } else {
                    if (Color.BLACK.equals((sibling.getRightChild()).getColor())) {
                        //case 3.3
                        (sibling.getLeftChild()).setColor(Color.BLACK);
                        sibling.setColor(Color.RED);
                        rightRotate(sibling);
                        sibling = node.getParent().getRightChild();
                    }
                    //case 3.4
                    sibling.setColor(node.getParent().getColor());
                    node.getParent().setColor(Color.BLACK);
                    sibling.getLeftChild().setColor(Color.BLACK);
                    leftRotate(node.getParent());
                    node = root;
                }
            } else {
                sibling = node.getParent().getLeftChild();

                if (Color.RED.equals(sibling.getColor())) {
                    //case 3.1
                    sibling.setColor(Color.BLACK);
                    node.getParent().setColor(Color.RED);
                    rightRotate(node.getParent());
                    sibling = node.getParent().getLeftChild();
                }
                if (Color.BLACK.equals(sibling.getLeftChild().getColor())
                        && Color.BLACK.equals(sibling.getRightChild().getColor())) {
                    //case 3.2
                    sibling.setColor(Color.RED);
                    node = node.getParent();
                } else {
                    if (Color.BLACK.equals((sibling.getLeftChild()).getColor())) {
                        //case 3.3
                        sibling.getRightChild().setColor(Color.BLACK);
                        sibling.setColor(Color.RED);
                        leftRotate(sibling);
                        sibling = node.getParent().getLeftChild();
                    }
                    //case 3.4
                    sibling.setColor(node.getParent().getColor());
                    node.getParent().setColor(Color.BLACK);
                    sibling.getLeftChild().setColor(Color.BLACK);
                    rightRotate(node.getParent());
                    node = root;
                }
            }
        }
        node.setColor(Color.BLACK);
    }

    /**
     * This method replaces one subtree as a child of its parent with another subtree. When Transplant replaces
     * the subtree rooted at node "u" with the subtree rooted at node "v", node u's parent becomes node v's parent
     * and u's parent ends up having "v" as its appropriate child.
     *
     * @param u - the node to be transplant with the node "v"
     * @param v - the node with which the "u" node will be transplant
     */
    private void rbTransplant(RBNode<V> u, RBNode<V> v) {
        if (u.getParent() == null) {
            this.root = v;
        } else if (u.equals(u.getParent().getLeftChild())) {
            u.getParent().setLeftChild(v);
        } else {
            u.getParent().setRightChild(v);
        }
        v.setParent(u.getParent());
    }

    /**
     * This method finds the smallest node in the tree.
     *
     * @param node - the node from which the search will begin.
     * @return - the smallest node
     */
    private RBNode<V> minimum(RBNode<V> node) {
        while (!node.getLeftChild().equals(TNULL)) {
            node = node.getLeftChild();
        }
        return node;
    }

    /**
     * This method returns true if node with the specified value is contained in the tree
     * and false if it is not contained.
     * @param value - the value of the searched node.
     * @return
     */
    public boolean contains(V value) {
        RBNode<V> rootNode = this.root;

        while (!rootNode.equals(TNULL)) {
            if (value.equals(rootNode.getValue())) {
                return true;
            }
            if (value.compareTo(rootNode.getValue()) >= 0) {
                rootNode = rootNode.getRightChild();
            } else {
                rootNode = rootNode.getLeftChild();
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return root.equals(TNULL);
    }

    public RBNode<V> first() {
        return first;
    }

    public RBNode<V> last() {
        return last;
    }

    /**
     * This method uses printHelper method to prints all the elements from the RedBlack tree.
     */
    public void print() {
        printHelper(this.root, "", true);
    }

    /**
     * This method prints all the elements from the RedBlack tree.
     */
    private void printHelper(RBNode<V> root, String indent, boolean last) {
        // print the tree structure on the screen
        if (root != TNULL) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "     ";
            } else {
                System.out.print("L----");
                indent += "|    ";
            }

            Color sColor = root.getColor();
            System.out.println(root.getValue() + "(" + sColor + ")");
            printHelper((RBNode<V>) root.getLeftChild(), indent, false);
            printHelper((RBNode<V>) root.getRightChild(), indent, true);
        }
    }
}

package com.scalefocus.training.collection.tree;

import com.scalefocus.training.collection.common.Color;
import com.scalefocus.training.collection.common.RBNode;


/**
 * @author Kristiyan SLavov
 */
public class RedBlackTree<K extends Comparable<K>, V extends Comparable<V>> {

    private RBNode<K, V> root;

    private RBNode<K, V> TNULL;

    private RBNode<K, V> last;

    private RBNode<K, V> first;

    private int size = 0;

    public RedBlackTree() {
        TNULL = new RBNode<>();
        TNULL.setColor(Color.BLACK);
        first = new RBNode<>();
        last = new RBNode<>();
        root = TNULL;
    }

    public RBNode<K, V> getRoot() {
        return this.root;
    }

    /**
     * This method inserts added new node to the RedBlack tree.The new node has a "RED" color
     * and a specified value and its position is determined by its root. If the root is empty,
     * the new node becomes the root of the RedBlack tree. After insertion, fixInsert method
     * is used to rebalanced the RedBlack tree.
     *
     * @param value - the value of the new node
     */
    public void insert(K key, V value) {
        RBNode<K, V> node = new RBNode<>(key, value, Color.RED);

        node.setParent(null);
        node.setLeftChild(TNULL);
        node.setRightChild(TNULL);

        RBNode<K, V> y = null;
        RBNode<K, V> x = this.root;
        while (x != TNULL) {
            y = x;
            //check if key already exists
            if (node.getKey().compareTo(x.getKey()) == 0) {
                x.setValue(node.getValue());
                return;
            }
            if (node.getKey().compareTo(x.getKey()) < 0) {
                x = x.getLeftChild();
            } else {
                x = x.getRightChild();
            }
        }

        node.setParent(y);
        if (y == null) {
            root = node;
            this.first = node;
        } else if (node.getKey().compareTo(y.getKey()) < 0) {
            y.setLeftChild(node);
        } else {
            y.setRightChild(node);
        }
        this.last = node;
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
    private void fixInsert(RBNode<K, V> newNode) {
        RBNode<K, V> uncle;
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
    private void leftRotate(RBNode<K, V> node) {
        RBNode<K, V> y = node.getRightChild();
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
    private void rightRotate(RBNode<K, V> node) {
        RBNode<K, V> y = node.getLeftChild();
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
     * @param key - the value of the node to be deleted
     */
    public RBNode delete(K key) {
        return deleteNodeHelper(this.root, key);
    }

    /**
     * This method removes a specified node from the RedBlack tree using
     * TRANSPLANT algorithm to replace the node to be deleted. After deletion,
     * the method use a fixDelete method to rebalanced the RedBlack tree.
     *
     * @param node - the root of the RedBlack tree
     * @param key  - the value of the node to be deleted
     */
    private RBNode<K, V> deleteNodeHelper(RBNode<K, V> node, K key) {
        //find the node, containing that value
        RBNode<K, V> deletedNode = TNULL;
        RBNode<K, V> x, y;

        while (!node.equals(TNULL)) {
            if (key.equals(node.getKey())) {
                deletedNode = node;
            }

            if (key.compareTo(node.getKey()) >= 0) {
                node = node.getRightChild();
            } else {
                node = node.getLeftChild();
            }
        }

        //couldn't find node with this value in the tree
        if (deletedNode.equals(TNULL)) {
            return null;
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
        return deletedNode;
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
    private void fixDelete(RBNode<K, V> node) {
        RBNode<K, V> sibling;

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
    private void rbTransplant(RBNode<K, V> u, RBNode<K, V> v) {
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
     * This method returns the least node in the tree.
     *
     * @return - the least node or null if the tree is empty.
     */
    public RBNode<K, V> minimumEntry() {
        return minimum(this.root);
    }

    /**
     * This method returns the greatest node in the tree.
     *
     * @return - the greatest node or null if the tree is empty.
     */
    public RBNode<K, V> maximumEntry() {
        return maximum(this.root);
    }

    /**
     * This method finds the greatest node in the tree/subtree.
     *
     * @param node - the node from which the search will begin.
     * @return - the greatest node
     */
    private RBNode<K, V> maximum(RBNode<K, V> node) {
        while (!node.getRightChild().equals(TNULL)) {
            node = node.getRightChild();
        }
        return node;
    }

    /**
     * This method finds the least node in the tree/subtree.
     *
     * @param node - the node from which the search will begin.
     * @return - the least node
     */
    private RBNode<K, V> minimum(RBNode<K, V> node) {
        while (!node.getLeftChild().equals(TNULL)) {
            node = node.getLeftChild();
        }
        return node;
    }

    /**
     * This method returns true if the tree contains a node with the specified value
     * or false if it is not contained.
     *
     * @param value - the value of the searched node.
     * @return - true if the tree contains a node with the specified value
     * or false if the tree does not contains the node
     */
    public boolean containsValue(V value) {
        RBNode<K, V> rootNode = this.root;

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

    /**
     * This method returns true if the tree contains a node with the specified key
     * or false if a node with the specified key is not contained into the tree.
     *
     * @param key - the specified key of a node
     * @return - true if tree contains a node with the specified key or
     * false if the tree does not contains the node.
     */
    public boolean containsKey(K key) {
        RBNode<K, V> rootNode = this.root;

        while (!rootNode.equals(TNULL)) {
            if (key.equals(rootNode.getKey())) {
                return true;
            }
            if (key.compareTo(rootNode.getKey()) >= 0) {
                rootNode = rootNode.getRightChild();
            } else {
                rootNode = rootNode.getLeftChild();
            }
        }
        return false;
    }

    /**
     * This method returns the number of key-value mappings in this tree.
     *
     * @return - number of key-value mappings
     */
    public int size() {
        return size;
    }

    /**
     * This method return true if the tree contains no key-value mappings.
     *
     * @return - true if the tree does not contains any elements or false if it does.
     */
    public boolean isEmpty() {
        return root.equals(TNULL);
    }

    /**
     * This method returns the first added element to the tree.
     *
     * @return - the first added element or null if the tree does not contain any elements.
     */
    public RBNode<K, V> first() {
        return this.first;
    }

    /**
     * This method returns the last added element to the tree.
     *
     * @return - the last added element or null if the tree does not contain any elements.
     */
    public RBNode<K, V> last() {
        return this.last;
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
    private void printHelper(RBNode<K, V> root, String indent, boolean last) {
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
            System.out.println(root.getKey() + "(" + sColor + ")");
            printHelper(root.getLeftChild(), indent, false);
            printHelper(root.getRightChild(), indent, true);
        }
    }
}

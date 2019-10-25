package com.scalefocus.training.collection.tree;

/**
 * @author Kristiyan SLavov
 */
public class RedBlackTree<V extends Comparable<V>> {

    private RBNode<V> root;

    private RBNode<V> TNULL;

    public RedBlackTree() {
        TNULL = new RBNode<>();
        TNULL.setColor("BLACK");
        root = TNULL;
    }

    public void insert(V value) {
        RBNode<V> node = new RBNode<>(value, "RED");
        node.setParent(null);
        node.setLeftChild(TNULL);
        node.setRightChild(TNULL);

        RBNode<V> y = null;
        RBNode<V> x = this.root;

        while (x != TNULL) {
            y = x;
            if (node.getValue().compareTo(x.getValue()) < 0) {
                x = x.getLeftChild();
            } else {
                x = x.getRightChild();
            }
        }

        node.setParent(y);
        if (y == null) {
            root = node;
        } else if (node.getValue().compareTo(y.getValue()) < 0) {
            y.setLeftChild(node);
        } else {
            y.setRightChild(node);
        }

        if (node.getParent() == null) {
            node.setColor("BLACK");
            return;
        }
        if (node.getParent().getParent() == null) {
            return;
        }

        fixInsert(node);
    }

    private void fixInsert(RBNode<V> k) {
        RBNode<V> uncle;
        while (k.getParent().getColor().equals("RED")) {
            if (k.getParent().equals(k.getParent().getParent().getRightChild())) {
                uncle = k.getParent().getParent().getLeftChild();

                if (uncle.getColor().equals("RED")) {
                    //case 3.1
                    uncle.setColor("BLACK");
                    k.getParent().setColor("BLACK");
                    k.getParent().getParent().setColor("RED");
                    k = k.getParent().getParent();
                } else {
                    if (k.equals(k.getParent().getLeftChild())) {
                        //case 3.2.2
                        k = k.getParent();
                        rightRotate(k);
                    }
                    //case 3.2.1
                    k.getParent().setColor("BLACK");
                    k.getParent().getParent().setColor("RED");
                    leftRotate(k.getParent().getParent());
                }
            } else {
                uncle = k.getParent().getParent().getRightChild();

                if (uncle.getColor().equals("RED")) {
                    //case 3.1
                    uncle.setColor("BLACK");
                    k.getParent().setColor("BLACK");
                    k.getParent().getParent().setColor("RED");
                    k = k.getParent().getParent();
                } else {
                    if (k.equals(k.getParent().getRightChild())) {
                        //mirror case 3.2.2
                        k = k.getParent();
                        leftRotate(k);
                    }
                    //mirror case 3.2.1
                    k.getParent().setColor("BLACK");
                    k.getParent().getParent().setColor("RED");
                    rightRotate(k.getParent().getParent());
                }
            }
            if (k.equals(root)) {
                break;
            }
        }
        root.setColor("BLACK");
    }

    private void leftRotate(RBNode<V> x) {
        RBNode<V> y = x.getRightChild();
        x.setRightChild(y.getLeftChild());

        if (y.getLeftChild().equals(TNULL)) {
            y.getLeftChild().setParent(x);
        }
        y.setParent(x.getParent());

        if (x.getParent() == null) {
            this.root = y;
        } else if (x == x.getParent().getLeftChild()) {
            x.getParent().setLeftChild(y);
        } else {
            x.getParent().setRightChild(y);
        }
        y.setLeftChild(x);
        x.setParent(y);
    }

    private void rightRotate(RBNode<V> x) {
        RBNode<V> y = x.getLeftChild();
        x.setLeftChild(y.getRightChild());
        if (y.getRightChild() != TNULL) {
            y.getRightChild().setParent(x);
        }
        y.setParent(x.getParent());

        if (x.getParent() == null) {
            this.root = y;
        } else if (x == x.getParent().getRightChild()) {
            x.getParent().setRightChild(y);
        } else {
            x.getParent().setLeftChild(y);
        }
        y.setRightChild(x);
        x.setParent(y);
    }

//    public void delete(V value) {
//        deleteNodeHelper(this.root, value);
//    }
//
//    private void deleteNodeHelper(RBNode<V> node, V value) {
//        //find the node, containing that value
//        RBNode<V> deletedNode = TNULL;
//        RBNode<V> x, y;
//
//        while (!node.equals(TNULL)) {
//            if (value.equals(node.getValue())) {
//                deletedNode = node;
//            }
//
//            if (value.compareTo(node.getValue()) >= 0) {
//                node = node.getRightChild();
//            } else {
//                node = node.getLeftChild();
//            }
//        }
//
//        //couldn't find node with this value in the tree
//        if (deletedNode.equals(TNULL)) {
//            return;
//        }
//        y = deletedNode;
//        String yOriginalColor = y.getColor();
//
//        if (deletedNode.getLeftChild().equals(TNULL)) {
//            x = deletedNode.getRightChild();
//            rbTransplant(deletedNode, deletedNode.getRightChild());
//
//        } else if (deletedNode.getRightChild().equals(TNULL)) {
//            x = deletedNode.getLeftChild();
//            rbTransplant(deletedNode, deletedNode.getLeftChild());
//
//        } else {
//            y = minimum(deletedNode.getRightChild());
//            yOriginalColor = y.getColor();
//            x = y.getRightChild();
//
//            //if minimum right node is the direct child of deleted node
//            if (y.getParent().equals(deletedNode)) {
//                x.setParent(y);
//            } else {
//                //else first transplant right of "y" to "y"
//                rbTransplant(y, y.getRightChild());
//                //right subtree of deleted note become right subtree of y node
//                y.setRightChild(deletedNode.getRightChild());
//                (y.getRightChild()).setParent(y);
//            }
//
//            rbTransplant(deletedNode, y);
//            y.setLeftChild(deletedNode.getLeftChild());
//            y.getLeftChild().setParent(y);
//            y.setColor(deletedNode.getColor());
//        }
//        if ("BLACK".equals(yOriginalColor)) {
//            fixDelete(x);
//        }
//    }
//
//    private void rbTransplant(RBNode<V> u, RBNode<V> v) {
//        if (u.getParent() == null) {
//            this.root = v;
//        } else if (u.equals(u.getParent().getLeftChild())) {
//            u.getParent().setLeftChild(v);
//        } else {
//            u.getParent().setRightChild(v);
//        }
//        v.setParent(u.getParent());
//    }
//
//    private RBNode<V> minimum(RBNode<V> node) {
//        while (!node.getLeftChild().equals(TNULL)) {
//            node = node.getLeftChild();
//        }
//        return node;
//    }
//
//    private void fixDelete(RBNode<V> x) {
//        RBNode<V> sibling = null;
//
//        while (!x.equals(root) && "BLACK".equals(x.getColor())) {
//            if (x.equals(x.getParent().getLeftChild())) {
//                sibling = x.getParent().getRightChild();
//
//                if ("RED".equals(sibling.getColor())) {
//                    //case 3.1
//                    sibling.setColor("BLACK");
//                    x.getParent().setColor("RED");
//                    rotateLeft(x.getParent());
//                    sibling = x.getRightChild().getRightChild();
//                }
//                if ("BLACK".equals((sibling.getLeftChild()).getColor())
//                        && "BLACK".equals((sibling.getRightChild()).getColor())) {
//                    //case 3.2
//                    sibling.setColor("RED");
//                    x = x.getParent();
//                } else {
//                    if ("BLACK".equals((sibling.getRightChild()).getColor())) {
//                        //case 3.3
//                        (sibling.getLeftChild()).setColor("BLACK");
//                        sibling.setColor("RED");
//                        rotateRight(sibling);
//                        sibling = x.getParent().getRightChild();
//                    }
//                    //case 3.4
//                    sibling.setColor(x.getParent().getColor());
//                    x.getParent().setColor("BLACK");
//                    sibling.getLeftChild().setColor("BLACK");
//                    rotateLeft(x.getParent());
//                    x = root;
//                }
//            } else {
//                sibling = x.getParent().getLeftChild();
//
//                if ("RED".equals(sibling.getColor())) {
//                    //case 3.1
//                    sibling.setColor("BLACK");
//                    x.getParent().setColor("RED");
//                    rotateRight(x.getParent());
//                    sibling = x.getParent().getLeftChild();
//                }
//                if ("BLACK".equals(sibling.getLeftChild().getColor())
//                        && "BLACK".equals(sibling.getRightChild().getColor())) {
//                    //case 3.2
//                    sibling.setColor("RED");
//                    x = x.getParent();
//                } else {
//                    if ("BLACK".equals((sibling.getLeftChild()).getColor())) {
//                        //case 3.3
//                        ((RBNode<V>) sibling.getRightChild()).setColor("BLACK");
//                        sibling.setColor("RED");
//                        rotateLeft(sibling);
//                        sibling = x.getParent().getLeftChild();
//                    }
//                    //case 3.4
//                    sibling.setColor(x.getParent().getColor());
//                    x.getParent().setColor("BLACK");
//                    ((RBNode<V>) sibling.getLeftChild()).setColor("BLACK");
//                    rotateRight(x.getParent());
//                    x = root;
//                }
//            }
//        }
//        x.setColor("BLACK");
//    }

    public void print() {
        printHelper(this.root, "", true);
    }

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

            String sColor = root.getColor();
            System.out.println(root.getValue() + "(" + sColor + ")");
            printHelper((RBNode<V>) root.getLeftChild(), indent, false);
            printHelper((RBNode<V>) root.getRightChild(), indent, true);
        }
    }
}

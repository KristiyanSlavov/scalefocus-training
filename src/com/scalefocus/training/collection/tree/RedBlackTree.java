package com.scalefocus.training.collection.tree;

/**
 * @author Kristiyan SLavov
 */
public class RedBlackTree<V extends Comparable<V>> {

    private RBNode<V> root;

    private RBNode<V> TNULL;

    //private BinarySearchTree<T> binarySearchTree = new BinarySearchTree<>();

    public RedBlackTree() {
        TNULL = new RBNode<>(null, "BLACK");
        TNULL.setColor("BLACK");
    }

    public void insert(V value) {
        RBNode<V> newNode = new RBNode<>(value, "RED");
        newNode.setRightChild(TNULL);
        newNode.setLeftChild(TNULL);

        RBNode<V> currentNode = null; //RBNode<V> currentNode
        RBNode<V> root = this.root; //RBNode<V> root

        while (root != TNULL) {
            currentNode = root;
            if (newNode.getValue().compareTo(root.getValue()) < 0) {
                root = (RBNode<V>) root.getLeftChild();
            } else {
                root = (RBNode<V>) root.getRightChild();
            }
        }

        newNode.setParent(currentNode);
        if (currentNode == null) {
            this.root = newNode;
        } else if (newNode.getValue().compareTo(currentNode.getValue()) < 0) {
            currentNode.setLeftChild(newNode);
        } else {
            currentNode.setRightChild(newNode);
        }
        //if new node is root node, then return
        if (newNode.getParent() == null) {
            newNode.setColor("BLACK");
            return;
        }
        //if grandparent is null, then return
        if (newNode.getParent().getParent() == null) {
            return;
        }
        //fix the tree
        fixInsert(newNode);
    }

        public void fixInsert(RBNode<V> newNode) {
            //RBNode<V> newNode = new RBNode<>(value, "RED");
            RBNode<V> uncle = null;

            while ("RED".equals(newNode.getParent().getColor())) {
                if (newNode.getParent() == newNode.getParent().getParent().getRightChild()) {
                    uncle = (RBNode<V>) newNode.getParent().getParent().getLeftChild();

                    if (uncle.getColor() == "RED") { //case 3.1
                        uncle.setColor("BLACK");
                        newNode.getParent().setColor("BLACK");
                        newNode.getParent().getParent().setColor("RED");
                        newNode = newNode.getParent().getParent();

                    } else {
                        if (newNode == newNode.getParent().getLeftChild()) {
                            //case 3.2.2 -triangle
                            newNode = newNode.getParent();
                            rightRotate(newNode);
                        }
                        //case 3.2.1 - inline
                        newNode.getParent().setColor("BLACK");
                        newNode.getParent().getParent().setColor("RED");
                        leftRotate(newNode.getParent().getParent());
                    }

                } else {
                    uncle = (RBNode<V>) newNode.getParent().getParent().getRightChild();

                    if (uncle.getColor() == "RED") { //mirror case 3.1
                        uncle.setColor("BLACK");
                        newNode.getParent().setColor("BLACK");
                        newNode.getParent().getParent().setColor("RED");
                        newNode = newNode.getParent().getParent();

                    } else {
                        if (newNode == newNode.getParent().getRightChild()) {
                            //mirror case 3.2.2
                            newNode = newNode.getParent();
                            leftRotate(newNode);
                        }
                        //mirror case 3.2.1
                        newNode.getParent().setColor("BLACK");
                        newNode.getParent().getParent().setColor("RED");
                        rightRotate(newNode.getParent().getParent());
                    }
                }
                if (newNode == root) {
                    break;
                }
            }
            root.setColor("BLACK");
        }

        private void rightRotate(RBNode<V> target) {
            RBNode<V> y = (RBNode<V>) target.getLeftChild();
            target.setLeftChild(y.getRightChild());

            if (y.getRightChild() != TNULL) {
                RBNode<V> yRightChild = (RBNode<V>) y.getRightChild();
                yRightChild.setParent(target);
            }
            y.setParent(target.getParent());

            if (target.getParent() == null) {
                this.root = y;
            } else if (target == target.getParent().getRightChild()) {
                target.getParent().setRightChild(y);
            } else {
                target.getParent().setLeftChild(y);
            }
            y.setRightChild(target);
            target.setParent(y);
        }

        private void leftRotate(RBNode<V> target) {
            RBNode<V> y = (RBNode<V>) target.getRightChild();
            target.setRightChild(y.getLeftChild());

            if (y.getLeftChild() != TNULL) {
                RBNode<V> yLeftChild = (RBNode<V>) y.getLeftChild();
                yLeftChild.setParent(target);
            }

            y.setParent(target.getParent());
            if (target.getParent() == null) {
                this.root = y;
            } else if (target == target.getParent().getLeftChild()) {
                target.getParent().setLeftChild(y);
            } else {
                target.getParent().setRightChild(y);
            }
            y.setLeftChild(target);
            target.setParent(y);
        }

        public void delete(V value) {
            deleteNodeHelper(this.root, value);
        }

        private void deleteNodeHelper(RBNode<V> node, V value) {
            //find the node, containing that value
            RBNode<V> deletedNode = TNULL;
            RBNode<V> x, y;

            while (node != TNULL) {
                if (node.getValue() == value) {
                    deletedNode = node;
                }

                if (value.compareTo(node.getValue()) >= 0) {
                    node = (RBNode<V>) node.getRightChild();
                } else {
                    node = (RBNode<V>) node.getLeftChild();
                }
            }

            //couldn't find node with this value in the tree
            if (deletedNode == TNULL) {
                return;
            }
            y = deletedNode;
            String yOriginalColor = y.getColor();

            if (deletedNode.getLeftChild().equals(TNULL)) {
                x = (RBNode<V>) deletedNode.getRightChild();
                rbTransplant(deletedNode, (RBNode<V>) deletedNode.getRightChild());
            } else if (deletedNode.getRightChild().equals(TNULL)) {
                x = (RBNode<V>) deletedNode.getLeftChild();
                rbTransplant(deletedNode, (RBNode<V>) deletedNode.getLeftChild());
            } else {
                y = minimum((RBNode<V>) deletedNode.getRightChild());
                yOriginalColor = y.getColor();
                x = (RBNode<V>) y.getRightChild();

                //if minimum right node is the direct child of deleted node
                if (y.getParent().equals(deletedNode)) {
                    x.setParent(y);
                } else {
                    //else first transplant right of "y" to "y"
                    rbTransplant(y, (RBNode<V>) y.getRightChild());
                    //right subtree of deleted note become right subtree of y node
                    y.setRightChild(deletedNode.getRightChild());
                    ((RBNode<V>) y.getRightChild()).setParent(y);
                }

                rbTransplant(deletedNode, y);
                y.setLeftChild(deletedNode.getLeftChild());
                ((RBNode<V>) y.getLeftChild()).setParent(y);
                y.setColor(deletedNode.getColor());
            }
            if ("BLACK".equals(yOriginalColor)) {
                fixDelete(x);
            }
        }

        private void rbTransplant(RBNode<V> u, RBNode<V> v) {
            if (u.getParent() == null) {
                this.root = v;
            } else if (u == u.getParent().getLeftChild()) {
                u.getParent().setLeftChild(v);
            } else {
                u.getParent().setRightChild(v);
            }
            v.setParent(u.getParent());
        }

        private RBNode<V> minimum(RBNode<V> node) {
            while (node.getLeftChild() != TNULL) {
                node = (RBNode<V>) node.getLeftChild();
            }
            return node;
        }

        private void fixDelete(RBNode<V> x) {
            RBNode<V> sibling = null;

            while (x != root && "BLACK".equals(x.getColor())) {
                if (x == x.getParent().getLeftChild()) {
                    sibling = (RBNode<V>) x.getParent().getRightChild();

                    if ("RED".equals(sibling.getColor())) {
                        //case 3.1
                        sibling.setColor("BLACK");
                        x.getParent().setColor("RED");
                        leftRotate(x.getParent());
                        sibling = (RBNode<V>) x.getRightChild().getRightChild();
                    }
                    if ("BLACK".equals(((RBNode<V>) sibling.getLeftChild()).getColor())
                            && "BLACK".equals(((RBNode<V>) sibling.getRightChild()).getColor())) {
                        //case 3.2
                        sibling.setColor("RED");
                        x = x.getParent();
                    } else {
                        if ("BLACK".equals(((RBNode<V>) sibling.getRightChild()).getColor())) {
                            //case 3.3
                            ((RBNode<V>) sibling.getLeftChild()).setColor("BLACK");
                            sibling.setColor("RED");
                            rightRotate(sibling);
                            sibling = (RBNode<V>) x.getParent().getRightChild();
                        }
                        //case 3.4
                        sibling.setColor(x.getParent().getColor());
                        x.getParent().setColor("BLACK");
                        ((RBNode<V>) sibling.getLeftChild()).setColor("BLACK");
                        leftRotate(x.getParent());
                        x = root;
                    }
                } else {
                    sibling = (RBNode<V>) x.getParent().getLeftChild();

                    if ("RED".equals(sibling.getColor())) {
                        //case 3.1
                        sibling.setColor("BLACK");
                        x.getParent().setColor("RED");
                        rightRotate(x.getParent());
                        sibling = (RBNode<V>) x.getParent().getLeftChild();
                    }
                    if ("BLACK".equals(((RBNode<V>) sibling.getLeftChild()).getColor())
                            && "BLACK".equals(((RBNode<V>) sibling.getRightChild()).getColor())) {
                        //case 3.2
                        sibling.setColor("RED");
                        x = x.getParent();
                    } else {
                        if ("BLACK".equals(((RBNode<V>) sibling.getLeftChild()).getColor())) {
                            //case 3.3
                            ((RBNode<V>) sibling.getRightChild()).setColor("BLACK");
                            sibling.setColor("RED");
                            leftRotate(sibling);
                            sibling = (RBNode<V>) x.getParent().getLeftChild();
                        }
                        //case 3.4
                        sibling.setColor(x.getParent().getColor());
                        x.getParent().setColor("BLACK");
                        ((RBNode<V>) sibling.getLeftChild()).setColor("BLACK");
                        rightRotate(x.getParent());
                        x = root;
                    }
                }
            }
            x.setColor("BLACK");
        }

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

package com.scalefocus.training.collection.tree;

import java.util.Objects;

/**
 * @author Kristiyan SLavov
 */
public class RBNode<V extends Comparable<V>> extends TreeNode<V, RBNode<V>> {

    private String color;

    public RBNode(V value, String color) {
        super(value);
        this.color = color;
    }

    public RBNode(TreeNode<V, TreeNode> treeNode) {
        super(treeNode.getValue());
//        if (treeNode.getRightChild() != null) {
//            setRightChild(new RBNode<>(treeNode.getRightChild()));
//        }
        if (treeNode.getParent() != null) {
            setParent(new RBNode<>(treeNode.getParent()));
        }
        if (treeNode.getLeftChild() != null) {
            setLeftChild(new RBNode<>(treeNode.getLeftChild()));
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RBNode<?> rbNode = (RBNode<?>) o;
        return color.equals(rbNode.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color);
    }
}

package com.keyin.binarytree.model;

public class BSTreeNode {
    private int value;
    private BSTreeNode left;
    private BSTreeNode right;

    // Constructor
    public BSTreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    // Getters
    public int getValue() {
        return value;
    }

    public BSTreeNode getLeft() {
        return left;
    }

    public BSTreeNode getRight() {
        return right;
    }

    // Setters
    public void setValue(int value) {
        this.value = value;
    }

    public void setLeft(BSTreeNode left) {
        this.left = left;
    }

    public void setRight(BSTreeNode right) {
        this.right = right;
    }
}
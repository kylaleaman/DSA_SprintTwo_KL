package com.keyin.binarytree.model;

public class BSTreeNodeJson {
    private int value;
    private BSTreeNodeJson left;
    private BSTreeNodeJson right;

    public BSTreeNodeJson(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BSTreeNodeJson getLeft() {
        return left;
    }

    public void setLeft(BSTreeNodeJson left) {
        this.left = left;
    }

    public BSTreeNodeJson getRight() {
        return right;
    }

    public void setRight(BSTreeNodeJson right) {
        this.right = right;
    }
}
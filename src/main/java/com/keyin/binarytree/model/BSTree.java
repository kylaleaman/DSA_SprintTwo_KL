package com.keyin.binarytree.model;

import java.util.ArrayList;
import java.util.List;

public class BSTree {
    private BSTreeNode root;

    public BSTree() {
        this.root = null;
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private BSTreeNode insertRec(BSTreeNode root, int value) {
        if (root == null) {
            root = new BSTreeNode(value);
            return root;
        }
        if (value < root.getValue()) {
            root.setLeft(insertRec(root.getLeft(), value));
        } else if (value > root.getValue()) {
            root.setRight(insertRec(root.getRight(), value));
        }
        return root;
    }

    public List<Integer> toList() {
        List<Integer> result = new ArrayList<>();
        inOrderTraversal(root, result);
        return result;
    }

    public void inOrderTraversal(BSTreeNode node, List<Integer> result) {
        if (node != null) {
            inOrderTraversal(node.getLeft(), result);
            result.add(node.getValue());
            inOrderTraversal(node.getRight(), result);
        }
    }

    public BSTreeNode getRoot() {
        return root;
    }
}
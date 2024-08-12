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

    public BSTreeNode getRoot() {
        return root;
    }

    // Converts the tree to a list of integers in in-order traversal
    public List<Integer> toList() {
        List<Integer> list = new ArrayList<>();
        inOrderTraversal(root, list);
        return list;
    }

    private void inOrderTraversal(BSTreeNode node, List<Integer> list) {
        if (node != null) {
            inOrderTraversal(node.getLeft(), list);
            list.add(node.getValue());
            inOrderTraversal(node.getRight(), list);
        }
    }
}

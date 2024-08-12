package com.keyin.binarytree.service;

import com.keyin.binarytree.model.BSTree;
import com.keyin.binarytree.model.BSTreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BSTServiceImplementTest {

    @Test
    public void testCreateTree() {
        BSTreeService bstService = new BSTServiceImplement();
        List<Integer> numbers = List.of(10, 5, 15);
        BSTree tree = bstService.createTree(numbers);

        List<Integer> result = tree.toList();
        List<Integer> expected = List.of(5, 10, 15);

        assertEquals(expected, result, "The tree should contain the numbers in the same order");
    }

    @Test
    public void testInOrderTraversal() {
        BSTree tree = new BSTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);

        List<Integer> result = new ArrayList<>();
        tree.inOrderTraversal(tree.getRoot(), result); // Ensure this matches the method signature

        List<Integer> expected = List.of(5, 10, 15);
        assertEquals(expected, result, "The in-order traversal result should match the expected list");
    }
}

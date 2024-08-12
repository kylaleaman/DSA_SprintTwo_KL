package com.keyin.binarytree.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class BSTreeTest {

    @Test
    public void testInsertAndToList() {
        BSTree tree = new BSTree();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);

        List<Integer> expected = Arrays.asList(2, 3, 4, 5, 6, 7, 8);
        List<Integer> actual = tree.toList();

        assertEquals(expected, actual);
    }
}

package com.keyin.binarytree.model;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BSTreeTest {

    @Test
    void testInsertAndToList() {
        BSTree tree = new BSTree();
        tree.insert(4);
        tree.insert(2);
        tree.insert(6);
        tree.insert(1);
        tree.insert(3);
        tree.insert(5);
        tree.insert(7);

        List<Integer> expectedList = List.of(1, 2, 3, 4, 5, 6, 7);
        assertEquals(expectedList, tree.toList());
    }
}

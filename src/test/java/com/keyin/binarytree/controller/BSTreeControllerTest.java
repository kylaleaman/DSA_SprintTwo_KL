package com.keyin.binarytree.controller;

import com.keyin.binarytree.model.BSTree;
import com.keyin.binarytree.model.BSTreeEntity;
import com.keyin.binarytree.service.BSTreeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BSTreeControllerTest {

    @Mock
    private BSTreeService bstreeService;

    @InjectMocks
    private BSTreeController bstreeController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testProcessNumbers() {
        List<Integer> numbers = List.of(5, 3, 7);
        BSTree tree = new BSTree();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);

        String treeJson = "{\"root\":5,\"left\":{\"root\":3},\"right\":{\"root\":7}}";
        BSTreeEntity entity = new BSTreeEntity("5,3,7", treeJson);

        when(bstreeService.createTree(numbers)).thenReturn(tree);
        when(bstreeService.convertTreeToJson(tree)).thenReturn(treeJson);
        when(bstreeService.saveTreeEntity(any(BSTreeEntity.class))).thenReturn(entity);

        ResponseEntity<BSTreeEntity> response = (ResponseEntity<BSTreeEntity>) bstreeController.processNumbers(numbers.toString());

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals("5,3,7", response.getBody().getNumbers());
    }

    @Test
    public void testGetPreviousTrees() {
        List<BSTreeEntity> trees = List.of(new BSTreeEntity("5,3,7", "{\"root\":5,\"left\":{\"root\":3},\"right\":{\"root\":7}}"));
        when(bstreeService.getAllTrees()).thenReturn(trees);

        ResponseEntity<List<BSTreeEntity>> response = bstreeController.getPreviousTrees();

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertFalse(response.getBody().isEmpty());
    }

    @Test
    public void testGetTreeById() {
        BSTreeEntity entity = new BSTreeEntity("5,3,7", "{\"root\":5,\"left\":{\"root\":3},\"right\":{\"root\":7}}");
        when(bstreeService.getTreeById(1L)).thenReturn(entity);

        ResponseEntity<BSTreeEntity> response = bstreeController.getTreeById(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals("5,3,7", response.getBody().getNumbers());
    }
}

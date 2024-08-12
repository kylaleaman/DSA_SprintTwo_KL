package com.keyin.binarytree.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.keyin.binarytree.model.BSTree;
import com.keyin.binarytree.model.BSTreeEntity;
import com.keyin.binarytree.service.BSTreeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Collections;
import java.util.List;

import static com.jayway.jsonpath.internal.path.PathCompiler.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringJUnitConfig
public class BSTreeControllerTest {

    @InjectMocks
    private BSTreeController bstreeController;

    @Mock
    private BSTreeService bstreeService;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        objectMapper = new ObjectMapper();
    }

    @Test
    void testProcessNumbers() throws JsonProcessingException {
        String numbers = "1,2,3,4";
        BSTree tree = new BSTree();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);

        String treeJson = "dummyJson";

        BSTreeEntity treeEntity = new BSTreeEntity(numbers, treeJson);
        when(bstreeService.createTree(anyList())).thenReturn(tree);
        when(bstreeService.convertTreeToJson(tree)).thenReturn(treeJson);
        when(bstreeService.saveTreeEntity(any(BSTreeEntity.class))).thenReturn(treeEntity);

        ResponseEntity<?> response = bstreeController.processNumbers(numbers);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(treeEntity, response.getBody());
    }

    @Test
    void testGetPreviousTrees() {
        List<BSTreeEntity> trees = Collections.singletonList(new BSTreeEntity("1,2,3", "dummyJson"));
        when(bstreeService.getAllTrees()).thenReturn(trees);

        ResponseEntity<List<BSTreeEntity>> response = bstreeController.getPreviousTrees();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(trees, response.getBody());
    }

    @Test
    void testGetTreeById() {
        Long id = 1L;
        BSTreeEntity treeEntity = new BSTreeEntity("1,2,3", "dummyJson");
        when(bstreeService.getTreeById(id)).thenReturn(treeEntity);

        ResponseEntity<BSTreeEntity> response = bstreeController.getTreeById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(treeEntity, response.getBody());
    }

    @Test
    void testGetTreeByIdNotFound() {
        Long id = 1L;
        when(bstreeService.getTreeById(id)).thenReturn(null);

        ResponseEntity<BSTreeEntity> response = bstreeController.getTreeById(id);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // Example of handling JsonProcessingException
    @Test
    void testJsonProcessing() {
        try {
            BSTree tree = new BSTree();
            tree.insert(1);
            tree.insert(2);
            tree.insert(3);
            tree.insert(4);
            String json = objectMapper.writeValueAsString(tree);
            assertEquals("{\"root\":{\"value\":1,\"left\":{\"value\":2,\"left\":null,\"right\":null},\"right\":{\"value\":3,\"left\":null,\"right\":null}}}", json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            fail("JsonProcessingException occurred");
        }
    }
}

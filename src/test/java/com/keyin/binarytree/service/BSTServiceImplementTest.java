package com.keyin.binarytree.service;

import com.keyin.binarytree.model.BSTree;
import com.keyin.binarytree.model.BSTreeEntity;
import com.keyin.binarytree.repository.BSTreeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class BSTServiceImplementTest {

    @Mock
    private BSTreeRepository bstreeRepository;

    @InjectMocks
    private BSTServiceImplement bstreeService; // Adjusted to the implementation class

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateTree() {
        List<Integer> numbers = List.of(10, 5, 15);
        BSTree tree = bstreeService.createTree(numbers);
        List<Integer> result = tree.inOrderTraversal();
        assertEquals(numbers, result, "The tree should contain the numbers in sorted order");
    }


    @Test
    public void testConvertTreeToJson() {
        List<Integer> numbers = List.of(10, 5, 15);
        BSTree tree = bstreeService.createTree(numbers);
        String treeJson = bstreeService.convertTreeToJson(tree);
        assertNotNull(treeJson, "Tree JSON should not be null");
    }

    @Test
    public void testSaveTreeEntity() {
        BSTreeEntity treeEntity = new BSTreeEntity("10,5,15", "{...}");
        when(bstreeRepository.save(treeEntity)).thenReturn(treeEntity);
        BSTreeEntity savedEntity = bstreeService.saveTreeEntity(treeEntity);
        assertNotNull(savedEntity, "Saved entity should not be null");
        verify(bstreeRepository, times(1)).save(treeEntity);
    }

    @Test
    public void testGetAllTrees() {
        List<BSTreeEntity> treeEntities = new ArrayList<>();
        when(bstreeRepository.findAll()).thenReturn(treeEntities);
        List<BSTreeEntity> result = bstreeService.getAllTrees();
        assertEquals(treeEntities, result, "The result should match the mocked list");
    }

    @Test
    public void testGetTreeById() {
        Long id = 1L;
        BSTreeEntity treeEntity = new BSTreeEntity("10,5,15", "{...}");
        when(bstreeRepository.findById(id)).thenReturn(Optional.of(treeEntity));
        BSTreeEntity result = bstreeService.getTreeById(id);
        assertNotNull(result, "The result should not be null");
        assertEquals(treeEntity, result, "The result should match the mocked entity");
    }
}
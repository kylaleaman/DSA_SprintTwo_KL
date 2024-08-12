package com.keyin.binarytree.service;

import com.keyin.binarytree.model.BSTree;
import com.keyin.binarytree.model.BSTreeEntity;
import com.keyin.binarytree.repository.BSTreeRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class BSTreeServiceImplTest {

    @InjectMocks
    private BSTreeServiceImpl bstreeService;

    @Mock
    private BSTreeRepository bstreeRepository;

    public BSTreeServiceImplTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetTreeById() {
        Long id = 1L;
        BSTreeEntity treeEntity = new BSTreeEntity("1,2,3", "dummyJson");
        when(bstreeRepository.findById(id)).thenReturn(Optional.of(treeEntity));

        BSTreeEntity result = bstreeService.getTreeById(id);

        assertEquals(treeEntity, result);
    }

    @Test
    void testGetAllTrees() {
        List<BSTreeEntity> trees = Collections.singletonList(new BSTreeEntity("1,2,3", "dummyJson"));
        when(bstreeRepository.findAll()).thenReturn(trees);

        List<BSTreeEntity> result = bstreeService.getAllTrees();

        assertEquals(trees, result);
    }

    @Test
    void testSaveTreeEntity() {
        BSTreeEntity treeEntity = new BSTreeEntity("1,2,3", "dummyJson");
        when(bstreeRepository.save(treeEntity)).thenReturn(treeEntity);

        BSTreeEntity result = bstreeService.saveTreeEntity(treeEntity);

        assertEquals(treeEntity, result);
    }
}
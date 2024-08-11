package com.keyin.binarytree.service;

import com.keyin.binarytree.model.BSTree;
import com.keyin.binarytree.model.BSTreeEntity;

import java.util.List;

public interface BSTreeService {
    BSTree createTree(List<Integer> numbers);
    String convertTreeToJson(BSTree tree);
    BSTreeEntity saveTreeEntity(BSTreeEntity treeEntity);
    List<BSTreeEntity> getAllTrees();
    BSTreeEntity getTreeById(Long id);
}
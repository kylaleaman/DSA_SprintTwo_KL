package com.keyin.binarytree.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.keyin.binarytree.model.BSTree;
import com.keyin.binarytree.model.BSTreeEntity;
import com.keyin.binarytree.model.BSTreeNode;
import com.keyin.binarytree.model.BSTreeNodeJson;
import com.keyin.binarytree.repository.BSTreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BSTreeServiceImpl implements BSTreeService {

    @Autowired
    private BSTreeRepository bstreeRepository;

    @Autowired
    private ObjectMapper objectMapper; // Add this line

    @Override
    public BSTreeEntity getTreeById(Long id) {
        return bstreeRepository.findById(id).orElse(null);
    }

    @Override
    public List<BSTreeEntity> getAllTrees() {
        return bstreeRepository.findAll();
    }

    @Override
    public BSTree createTree(List<Integer> numbers) {
        BSTree tree = new BSTree();
        for (int number : numbers) {
            tree.insert(number);
        }
        return tree;
    }

    @Override
    public String convertTreeToJson(BSTree tree) throws JsonProcessingException {
        BSTreeNodeJson rootJson = convertNodeToJson(tree.getRoot());
        // Use a JSON library to convert rootJson to a JSON string
        return new ObjectMapper().writeValueAsString(rootJson);
    }

    private BSTreeNodeJson convertNodeToJson(BSTreeNode node) {
        if (node == null) {
            return null;
        }
        BSTreeNodeJson nodeJson = new BSTreeNodeJson(node.getValue());
        nodeJson.setLeft(convertNodeToJson(node.getLeft()));
        nodeJson.setRight(convertNodeToJson(node.getRight()));
        return nodeJson;
    }


    @Override
    public BSTreeEntity saveTreeEntity(BSTreeEntity treeEntity) {
        return bstreeRepository.save(treeEntity);
    }
}
package com.keyin.binarytree.service;

import com.keyin.binarytree.model.BSTree;
import com.keyin.binarytree.model.BSTreeEntity;
import com.keyin.binarytree.repository.BSTreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BSTreeServiceImpl implements BSTreeService {

    @Autowired
    private BSTreeRepository bstreeRepository;

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
        return null;
    }

    @Override
    public String convertTreeToJson(BSTree tree) {
        return "";
    }

    @Override
    public BSTreeEntity saveTreeEntity(BSTreeEntity treeEntity) {
        return bstreeRepository.save(treeEntity);
    }
}

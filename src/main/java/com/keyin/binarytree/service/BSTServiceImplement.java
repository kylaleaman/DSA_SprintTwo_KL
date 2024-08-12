package com.keyin.binarytree.service;

import com.keyin.binarytree.model.BSTree;
import com.keyin.binarytree.model.BSTreeEntity;
import com.keyin.binarytree.repository.BSTreeRepository;
import com.keyin.binarytree.service.BSTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BSTServiceImplement implements BSTreeService {

    @Autowired
    private BSTreeRepository bstreeRepository;

    @Override
    public BSTree createTree(List<Integer> numbers) {
        BSTree tree = new BSTree();
        for (int number : numbers) {
            tree.insert(number);
        }
        return tree;
    }

    @Override
    public String convertTreeToJson(BSTree tree) {
        // Placeholder for actual JSON conversion logic
        return tree.toList().toString();
    }

    @Override
    public BSTreeEntity saveTreeEntity(BSTreeEntity treeEntity) {
        return bstreeRepository.save(treeEntity);
    }

    @Override
    public List<BSTreeEntity> getAllTrees() {
        return bstreeRepository.findAll();
    }

    @Override
    public BSTreeEntity getTreeById(Long id) {
        return bstreeRepository.findById(id).orElse(null);
    }
}

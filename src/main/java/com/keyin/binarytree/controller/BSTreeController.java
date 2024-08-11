package com.keyin.binarytree.controller;

import com.keyin.binarytree.model.BSTree;
import com.keyin.binarytree.model.BSTreeEntity;
import com.keyin.binarytree.service.BSTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class BSTreeController {

    @Autowired
    private BSTreeService bstreeService;

    @PostMapping("/process-numbers")
    public ResponseEntity<BSTreeEntity> processNumbers(@RequestBody List<Integer> numbers) {
        BSTree tree = bstreeService.createTree(numbers);
        String treeJson = bstreeService.convertTreeToJson(tree);

        BSTreeEntity treeEntity = new BSTreeEntity(
                numbers.stream().map(String::valueOf).collect(Collectors.joining(",")),
                treeJson
        );
        BSTreeEntity savedEntity = bstreeService.saveTreeEntity(treeEntity);

        return ResponseEntity.ok(savedEntity);
    }

    @GetMapping("/previous-trees")
    public ResponseEntity<List<BSTreeEntity>> getPreviousTrees() {
        List<BSTreeEntity> trees = bstreeService.getAllTrees();
        return ResponseEntity.ok(trees);
    }

    @GetMapping("/tree/{id}")
    public ResponseEntity<BSTreeEntity> getTreeById(@PathVariable Long id) {
        BSTreeEntity treeEntity = bstreeService.getTreeById(id);
        if (treeEntity != null) {
            return ResponseEntity.ok(treeEntity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
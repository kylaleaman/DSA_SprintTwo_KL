package com.keyin.binarytree.controller;

import com.keyin.binarytree.model.BSTree;
import com.keyin.binarytree.service.BSTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class BSTreeController {

    // Assuming you have a service to handle database operations
    @Autowired
    private BSTreeService bsTreeService;

    @PostMapping("/process-numbers")
    public ResponseEntity<Map<String, Object>> processNumbers(@RequestBody List<Integer> numbers) {
        BSTree bst = new BSTree();
        numbers.forEach(bst::insert);

        List<Integer> treeList = bst.toList();

        // Save numbers and tree structure to the database\
        return ResponseEntity.ok(Map.of("tree", treeList));
    }
}


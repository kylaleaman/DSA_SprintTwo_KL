package com.keyin.binarytree.controller;

import com.keyin.binarytree.model.BSTreeEntity;
import com.keyin.binarytree.service.BSTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class BSTreeWebController {

    @Autowired
    private BSTreeService bsTreeService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/enter-numbers")
    public String enterNumbers() {
        return "enterNumbers";
    }

    @GetMapping("/view-tree/{id}")
    public String viewTree(@PathVariable Long id, Model model) {
        BSTreeEntity treeEntity = bsTreeService.getTreeById(id);
        if (treeEntity != null) {
            model.addAttribute("tree", treeEntity);
            return "viewTree";
        } else {
            return "error";
        }
    }

    @GetMapping("/previous-trees")
    public String previousTrees(Model model) {
        List<BSTreeEntity> trees = bsTreeService.getAllTrees();
        model.addAttribute("trees", trees);
        return "showPrevious";
    }
}
package com.keyin.binarytree.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class BinaryTreeController {
    @GetMapping
    public String test() {
        return "PostgreSQL connection is working";
    }
}

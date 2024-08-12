package com.keyin.binarytree.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "numberInput")
public class BSTreeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "numbers", columnDefinition = "TEXT")
    private String numbers;

    @Column(name = "tree_structure", columnDefinition = "TEXT")
    private String treeStructure;

    // Default constructor
    public BSTreeEntity() {}

    // Parameterized constructor
    public BSTreeEntity(String numbers, String treeStructure) {
        this.numbers = numbers;
        this.treeStructure = treeStructure;
        this.createdAt = LocalDateTime.now();
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public String getTreeStructure() {
        return treeStructure;
    }

    public void setTreeStructure(String treeStructure) {
        this.treeStructure = treeStructure;
    }

    @Override
    public String toString() {
        return "BSTreeEntity{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", numbers='" + numbers + '\'' +
                ", treeStructure='" + treeStructure + '\'' +
                '}';
    }
}
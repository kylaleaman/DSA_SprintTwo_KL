package com.keyin.binarytree.repository;

import com.keyin.binarytree.model.BSTreeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BSTreeRepository extends JpaRepository<BSTreeEntity, Long> {
}
package com.rkasibha.springbootdemo.repository;

import com.rkasibha.springbootdemo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRespository extends JpaRepository<Author, Integer> {
}

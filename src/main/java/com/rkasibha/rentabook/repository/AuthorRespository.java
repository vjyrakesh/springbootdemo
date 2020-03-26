package com.rkasibha.rentabook.repository;

import com.rkasibha.rentabook.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRespository extends JpaRepository<Author, Integer> {
}

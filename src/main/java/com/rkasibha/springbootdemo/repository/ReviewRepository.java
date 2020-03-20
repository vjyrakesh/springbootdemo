package com.rkasibha.springbootdemo.repository;

import com.rkasibha.springbootdemo.model.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Integer> {
}

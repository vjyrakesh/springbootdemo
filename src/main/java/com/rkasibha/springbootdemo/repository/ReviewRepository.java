package com.rkasibha.springbootdemo.repository;

import com.rkasibha.springbootdemo.model.Book;
import com.rkasibha.springbootdemo.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

    public List<Review> findAllReviewsByBook(Book book);
}

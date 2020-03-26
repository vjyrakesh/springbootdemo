package com.rkasibha.rentabook.repository;

import com.rkasibha.rentabook.model.Book;
import com.rkasibha.rentabook.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

    public List<Review> findAllReviewsByBook(Book book);
}

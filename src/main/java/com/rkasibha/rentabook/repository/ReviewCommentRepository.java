package com.rkasibha.rentabook.repository;

import com.rkasibha.rentabook.model.Review;
import com.rkasibha.rentabook.model.ReviewComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewCommentRepository extends JpaRepository<ReviewComment, Integer> {

    public List<ReviewComment> findByReview(Review review);
}

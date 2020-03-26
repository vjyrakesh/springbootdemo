package com.rkasibha.rentabook.service;

import com.rkasibha.rentabook.repository.ReviewCommentRepository;
import com.rkasibha.rentabook.model.Book;
import com.rkasibha.rentabook.model.Review;
import com.rkasibha.rentabook.model.ReviewComment;
import com.rkasibha.rentabook.repository.BookRepository;
import com.rkasibha.rentabook.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ReviewCommentRepository reviewCommentRepository;

    public List<Review> fetchAllReviews() {
        List<Review> reviews = new ArrayList<>();
        reviewRepository.findAll().forEach(reviews::add);
        return reviews;
    }

    public Review fetchOneReview(Integer id) {
        return reviewRepository.findById(id).get();
    }

    public List<ReviewComment> fetchCommentsForReview(Integer reviewId) {
        List<ReviewComment> reviewComments = new ArrayList<>();
        Review review = reviewRepository.findById(reviewId).get();
        return reviewCommentRepository.findByReview(review);
    }

    public ReviewComment addReviewComment(Integer reviewId, ReviewComment reviewComment) {
        Review review = reviewRepository.findById(reviewId).get();
        reviewComment.setReview(review);
        return reviewCommentRepository.save(reviewComment);
    }

    public Review addBookReview(Book book, Review review) {
        review.setBook(book);
        return reviewRepository.save(review);
    }


}

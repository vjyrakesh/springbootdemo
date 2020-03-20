package com.rkasibha.springbootdemo.service;

import com.rkasibha.springbootdemo.annotation.MeasureExecutionTime;
import com.rkasibha.springbootdemo.exception.BookNotFoundException;
import com.rkasibha.springbootdemo.model.Book;
import com.rkasibha.springbootdemo.model.Review;
import com.rkasibha.springbootdemo.repository.BookRepository;
import com.rkasibha.springbootdemo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @MeasureExecutionTime
    public List<Book> getAllBooks() {
        return bookRepository.findAll();

    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public Book getOneBook(Integer id) throws BookNotFoundException {
        return bookRepository.findById(id).get();
    }

    public List<Review> getAllReviews(Integer bookId) {
        Book book = bookRepository.findById(bookId).get();
        return reviewRepository.findAllReviewsByBook(book);
    }

}

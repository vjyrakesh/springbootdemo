package com.rkasibha.rentabook.service;

import com.rkasibha.rentabook.annotation.MeasureExecutionTime;
import com.rkasibha.rentabook.exception.BookNotFoundException;
import com.rkasibha.rentabook.model.Author;
import com.rkasibha.rentabook.model.Book;
import com.rkasibha.rentabook.model.Review;
import com.rkasibha.rentabook.repository.ReviewRepository;
import com.rkasibha.rentabook.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ReviewService reviewService;

    @MeasureExecutionTime
    public List<Book> getAllBooks() {
        return bookRepository.findAll();

    }

    public void addBook(Book book) {
        Set<Author> authors = book.getAuthors();
        for(Author author : authors)
            System.out.println(author.getFirstName() + " " + author.getLastName());
        bookRepository.save(book);
    }

    public Book getOneBook(Integer id) throws BookNotFoundException {
        return bookRepository.findById(id).get();
    }

    public List<Review> getAllReviews(Integer bookId) {
        Book book = bookRepository.findById(bookId).get();
        return book.getReviews();
    }

    public Review addBookReview(Integer bookId, Review review) {
        Book book = bookRepository.findById(bookId).get();
        return reviewService.addBookReview(book, review);
    }

}

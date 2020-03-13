package com.rkasibha.springbootdemo.service;

import com.rkasibha.springbootdemo.model.Book;
import com.rkasibha.springbootdemo.exception.BookNotFoundException;
import com.rkasibha.springbootdemo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Collection<Book> getAllBooks() {
        return bookRepository.getAllBooks();

    }

    public void addBook(Book book) {
        bookRepository.addBook(book);
    }

    public Book getOneBook(long id) throws BookNotFoundException {
        return bookRepository.getBookById(id);
    }
}

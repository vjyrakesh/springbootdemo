package com.rkasibha.springbootdemo.repository;


import com.rkasibha.springbootdemo.model.Book;
import com.rkasibha.springbootdemo.exception.BookNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class BookRepository {

    Map<Long, Book> bookMap = new HashMap<Long, Book>();

    private static int id = 0;

    public void addBook(Book book) {
        book.setId(++id);
        bookMap.put(book.getId(), book);
    }

    public Collection<Book> getAllBooks() {
        return bookMap.values();
    }

    public Book getBookById(long id) throws BookNotFoundException{
        Book book = bookMap.get((Long)id);
        if (book == null) {
            throw new BookNotFoundException();
        } else
            return bookMap.get((Long)id);
    }
}

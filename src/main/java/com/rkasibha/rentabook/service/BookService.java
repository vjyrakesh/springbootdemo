package com.rkasibha.rentabook.service;

import com.rkasibha.rentabook.annotation.MeasureExecutionTime;
import com.rkasibha.rentabook.dto.BookAuthorInfoDto;
import com.rkasibha.rentabook.dto.BookDto;
import com.rkasibha.rentabook.dto.PublisherInfoDto;
import com.rkasibha.rentabook.exception.BookNotFoundException;
import com.rkasibha.rentabook.model.*;
import com.rkasibha.rentabook.repository.BookPublisherRepository;
import com.rkasibha.rentabook.repository.BookRepository;
import com.rkasibha.rentabook.repository.PublisherRepository;
import com.rkasibha.rentabook.repository.ReviewRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
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

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private PublisherService publisherService;

    @Autowired
    private BookPublisherRepository bookPublisherRepository;

    @Autowired
    private ModelMapper mapper;

    @MeasureExecutionTime
    public List<Book> getAllBooks() {
        return bookRepository.findAll();

    }

    public Book addBook1(Book book) {
        Set<Author> authors = book.getAuthors();
        for(Author author : authors)
            System.out.println(author.getFirstName() + " " + author.getLastName());
        Set<BookPublisher> publishers = book.getPublishers();
        Set<BookPublisher> toAddPublishers = new HashSet<>();
        for(BookPublisher publisher : publishers) {
            System.out.println(publisher.getPublisher().getName());

            Publisher addedPublisher = publisherRepository.save(publisher.getPublisher());
//            BookPublisher toAddBookPublisher = bookPublisherRepository.save(new BookPublisher(book, addedPublisher, publisher.getFormat()));
//            toAddPublishers.add(toAddBookPublisher);
        }
//        book.setPublishers(toAddPublishers);
        Book addedBook = bookRepository.save(book);
        Set<BookPublisher> bookPublishers = addedBook.getPublishers();
        for(BookPublisher publisher : bookPublishers)
            System.out.println(publisher.getPublisher().getName() + " :: " + publisher.getPublisher().getId());
        System.out.println(addedBook.getPublishers());
        return addedBook;
    }

    @Transactional
    public Book addBook(BookDto bookDto) {
        Book book = new Book();
        book.setName(bookDto.getName());
        for(BookAuthorInfoDto authorDto: bookDto.getAuthorInfo()) {
            book.getAuthors().add(new Author(authorDto.getFirstName(), authorDto.getLastName()));
        }
        Book addedBook = bookRepository.save(book);
        System.out.println(addedBook.getName() + "::" + addedBook.getId());

        Set<PublisherInfoDto> publishers = bookDto.getPublisherInfo();
        for(PublisherInfoDto bookPublisherDto : publishers) {
            Publisher publisher = publisherService.getPublisher(bookPublisherDto.getName());
            System.out.println(publisher.getName() + "::" + publisher.getId());
            BookPublisher bookPublisher = new BookPublisher(addedBook, publisher, bookPublisherDto.getFormat());
            bookPublisherRepository.save(bookPublisher);
        }
        return addedBook;
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

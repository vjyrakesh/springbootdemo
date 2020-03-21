package com.rkasibha.springbootdemo.controller;

import com.rkasibha.springbootdemo.dto.*;
import com.rkasibha.springbootdemo.exception.BookNotFoundException;
import com.rkasibha.springbootdemo.model.*;
import com.rkasibha.springbootdemo.repository.ReviewRepository;
import com.rkasibha.springbootdemo.service.BookService;
import com.rkasibha.springbootdemo.service.ReviewService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping(value = "/books")
public class BooksController {

    @Autowired
    private BookService bookService;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ReviewService reviewService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<BookDto>> getBooks() {
        List<Book> books = bookService.getAllBooks();
        List<BookDto> bookDtos = new ArrayList<>();
        for(Book book : books)
            bookDtos.add(mapper.map(book, BookDto.class));
        return new ResponseEntity<List<BookDto>>(bookDtos, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<BookDto> addBook(@Valid @RequestBody BookDto book) {
        bookService.addBook(convertBookDtoToEntity(book));
        return new ResponseEntity<BookDto>(book, HttpStatus.CREATED);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<BookDto> getOneBook(@PathVariable Integer id) {
        try {
            Book book = bookService.getOneBook(id);
            BookDto bookDto = mapper.map(book, BookDto.class);
            return new ResponseEntity<BookDto>(bookDto, HttpStatus.OK);
        } catch (BookNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Book with id:%d not found", id), ex);
        }
    }

    @RequestMapping(value = "/{id}/reviews", method = RequestMethod.POST)
    public ResponseEntity<ReviewDto> addBookReview(@PathVariable Integer id, @RequestBody ReviewDto reviewDto) {
        Review review = mapper.map(reviewDto, Review.class);
        ReviewDto addedReviewDto = mapper.map(bookService.addBookReview(id, review), ReviewDto.class);
        return new ResponseEntity<>(addedReviewDto, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/reviews", method = RequestMethod.GET)
    public ResponseEntity<List<ReviewDto>> getBookReviews(@PathVariable Integer id) {
        List<Review> reviews = bookService.getAllReviews(id);
        List<ReviewDto> reviewDtos = new ArrayList<>();
        for(Review review : reviews)
            reviewDtos.add(mapper.map(review, ReviewDto.class));
        return new ResponseEntity<>(reviewDtos, HttpStatus.OK);
    }

    @RequestMapping(value="/reviews", method = RequestMethod.POST)
    public ResponseEntity<ReviewDto> addReview(@RequestBody ReviewDto reviewDto) {
        Review review = convertReviewDtoToReview(reviewDto);
        Review addedReview = reviewRepository.save(review);
        return new ResponseEntity<ReviewDto>(mapper.map(addedReview, ReviewDto.class), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/reviews", method = RequestMethod.GET)
    public ResponseEntity<List<ReviewDto>> getAllReviews() {
        List<ReviewDto> reviewDtos = new ArrayList<>();
        List<Review> reviews = reviewService.fetchAllReviews();
        for(Review review: reviews) {
            reviewDtos.add(mapper.map(review, ReviewDto.class));
        }
        return new ResponseEntity<List<ReviewDto>>(reviewDtos, HttpStatus.OK);
    }

    @RequestMapping(value = "/reviews/{id}", method = RequestMethod.GET)
    public ResponseEntity<ReviewDto> getOneReview(@PathVariable Integer id) {
        return new ResponseEntity<>(mapper.map(reviewService.fetchOneReview(id), ReviewDto.class), HttpStatus.OK);
    }

    @RequestMapping(value = "/reviews/{id}/comments", method = RequestMethod.POST)
    public ResponseEntity<ReviewCommentDto> addReviewComment(@PathVariable Integer id,
                                                          @RequestBody ReviewCommentDto reviewCommentDto) {
        ReviewComment addedComment =
                reviewService.addReviewComment(id, convertReviewCommentDtoToEntity(reviewCommentDto));
        ReviewCommentDto addedCommentDto = mapper.map(addedComment, ReviewCommentDto.class);
        return new ResponseEntity<>(addedCommentDto, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/reviews/{id}/comments", method = RequestMethod.GET)
    public ResponseEntity<List<ReviewCommentDto>> fetchReviewComments(@PathVariable Integer id) {
        List<ReviewComment> reviewComments = reviewService.fetchCommentsForReview(id);
        List<ReviewCommentDto> reviewCommentDtos = new ArrayList<>();
        for(ReviewComment reviewComment : reviewComments) {
            reviewCommentDtos.add(mapper.map(reviewComment, ReviewCommentDto.class));
        }
        return new ResponseEntity<>(reviewCommentDtos, HttpStatus.OK);
    }



    private Book convertBookDtoToEntity(BookDto bookDto) {
        // You could either create the entity object manually by extracting the fields from the DTO object
        // and populating each field again into the entity object.
        // Or use a ModelMapper to map the DTO object into the entity class
        Book mappedBook = mapper.map(bookDto, Book.class);
        return mappedBook;
    }

    private ReviewComment convertReviewCommentDtoToEntity(ReviewCommentDto reviewCommentDto) {
        ReviewComment reviewComment = mapper.map(reviewCommentDto, ReviewComment.class);
        return reviewComment;
    }

    private Review convertReviewDtoToReview(ReviewDto reviewDto) {
        return mapper.map(reviewDto, Review.class);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Map<String,String> handleBadInput(MethodArgumentNotValidException ex) {
        Map<String,String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError)error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}

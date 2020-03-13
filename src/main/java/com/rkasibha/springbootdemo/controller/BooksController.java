package com.rkasibha.springbootdemo.controller;

import com.rkasibha.springbootdemo.dto.AddressDto;
import com.rkasibha.springbootdemo.dto.AuthorDto;
import com.rkasibha.springbootdemo.dto.BookDto;
import com.rkasibha.springbootdemo.exception.BookNotFoundException;
import com.rkasibha.springbootdemo.model.Address;
import com.rkasibha.springbootdemo.model.Author;
import com.rkasibha.springbootdemo.model.Book;
import com.rkasibha.springbootdemo.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping(value = "api/v1/books")
public class BooksController {

    @Autowired
    private BookService bookService;

    @Autowired
    private ModelMapper mapper;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Collection<Book>> getBooks() {
        return new ResponseEntity<Collection<Book>>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<BookDto> addBook(@Valid @RequestBody BookDto book) {
        bookService.addBook(convertBookDtoToEntity(book));
        return new ResponseEntity<BookDto>(book, HttpStatus.CREATED);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<BookDto> getOneBook(@PathVariable long id) {
        try {
            Book book = bookService.getOneBook(id);
            ModelMapper mapper = new ModelMapper();
            BookDto bookDto = mapper.map(book, BookDto.class);
            return new ResponseEntity<BookDto>(bookDto, HttpStatus.OK);
        } catch (BookNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Book with id:%d not found", id), ex);
        }
    }

    @RequestMapping(value = "/author", method = RequestMethod.GET)
    public ResponseEntity<AuthorDto> getAuthorDetails() {
        Address address = new Address("Bangalore", "India");
        Author author = new Author("Rakesh", "Kasibhatla", address);
        author.setAddress(address);

        AuthorDto authorDto = mapper.map(author, AuthorDto.class);
        authorDto.setAddress(mapper.map(address, AddressDto.class));
        return new ResponseEntity<AuthorDto>(authorDto, HttpStatus.OK);
    }

    @RequestMapping(value = "/authors", method = RequestMethod.POST)
    public ResponseEntity<AuthorDto> addAuthor(@RequestBody AuthorDto authorDto) {
        AuthorDto authorDto1 = new AuthorDto();
        authorDto1.setFirstName(authorDto.getFirstName());
        authorDto1.setLastName(authorDto.getLastName());
        authorDto1.setAddress(authorDto.getAddress());
        return new ResponseEntity<AuthorDto>(authorDto1, HttpStatus.CREATED);
    }

    private Book convertBookDtoToEntity(BookDto bookDto) {
        // You could either create the entity object manually by extracting the fields from the DTO object
        // and populating each field again into the entity object.
        Book newBook = new Book(1, bookDto.getName(),
                new Author(bookDto.getAuthor().getFirstName(), bookDto.getAuthor().getLastName(),
                        new Address(bookDto.getAuthor().getAddress().getCity(),
                                bookDto.getAuthor().getAddress().getCountry())));

        // Or use a ModelMapper to map the DTO object into the entity class
        Book mappedBook = mapper.map(bookDto, Book.class);
        return mappedBook;
    }
}

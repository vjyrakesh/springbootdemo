package com.rkasibha.rentabook.model;

import javax.persistence.*;

@Entity
public class BookPublisher {

    @EmbeddedId
    private BookPublisherId id = new BookPublisherId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("bookId")
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("publisherId")
    private Publisher publisher;

    private String format;

    public BookPublisher() {
    }

    public BookPublisher(Book book, Publisher publisher, String format) {
        this.book = book;
        this.publisher = publisher;
        this.format = format;
        this.id = new BookPublisherId(book.getId(), publisher.getId());
    }

    public BookPublisherId getBookPublisherId() {
        return id;
    }

    public void setBookPublisherId(BookPublisherId bookPublisherId) {
        this.id = bookPublisherId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}

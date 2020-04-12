package com.rkasibha.rentabook.dto;

public class BookPublisherDto {

    private BookDto book;
    private PublisherDto publisher;
    private String format;

    public BookPublisherDto() {
    }

    public BookDto getBook() {
        return book;
    }

    public void setBook(BookDto book) {
        this.book = book;
    }

    public PublisherDto getPublisher() {
        return publisher;
    }

    public void setPublisher(PublisherDto publisher) {
        this.publisher = publisher;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}

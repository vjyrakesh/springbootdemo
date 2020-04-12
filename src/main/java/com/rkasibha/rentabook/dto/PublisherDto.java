package com.rkasibha.rentabook.dto;

import java.util.Set;

public class PublisherDto {

    private Integer id;
    private String name;
    private Set<BookPublisherDto> books;

    public PublisherDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<BookPublisherDto> getBooks() {
        return books;
    }

    public void setBooks(Set<BookPublisherDto> books) {
        this.books = books;
    }
}

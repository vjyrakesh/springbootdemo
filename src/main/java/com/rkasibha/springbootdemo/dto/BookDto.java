package com.rkasibha.springbootdemo.dto;

public class BookDto {

    private String name;
    private AuthorDto author;

    public BookDto() {}

    public BookDto(String name, AuthorDto author) {
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AuthorDto getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDto author) {
        this.author = author;
    }
}

package com.rkasibha.springbootdemo.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

public class BookDto {

    @NotBlank(message="Book name is mandatory")
    private String name;

    @Valid
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

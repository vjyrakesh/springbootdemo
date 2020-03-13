package com.rkasibha.springbootdemo.model;

import javax.validation.constraints.NotNull;

public class Book {

    @NotNull
    private long id;

    @NotNull
    private String name;

    @NotNull
    private Author author;

    public Book() {

    }

    public Book(long id, String name, Author author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}

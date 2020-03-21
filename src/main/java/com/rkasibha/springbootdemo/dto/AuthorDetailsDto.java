package com.rkasibha.springbootdemo.dto;

import java.util.Set;

public class AuthorDetailsDto {

    private Integer id;
    private String firstName;
    private String lastName;
    private Set<AuthorBookDetailsDto> books;

    public AuthorDetailsDto() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<AuthorBookDetailsDto> getBooks() {
        return books;
    }

    public void setBooks(Set<AuthorBookDetailsDto> books) {
        this.books = books;
    }
}

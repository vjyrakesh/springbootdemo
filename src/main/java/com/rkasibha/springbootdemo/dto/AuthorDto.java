package com.rkasibha.springbootdemo.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.rkasibha.springbootdemo.annotation.CustomNameConstraint;

import javax.validation.constraints.NotBlank;
import java.util.Set;

public class AuthorDto {

    private Integer id;

    @NotBlank(message = "First name cannot be blank")
    private String firstName;

    @CustomNameConstraint
    private String lastName;
//    private AddressDto address;

    @JsonBackReference
    private Set<BookDto> books;

    public AuthorDto() {}

//    public AddressDto getAddress() {
//        return address;
//    }
//
//    public void setAddress(AddressDto address) {
//        this.address = address;
//    }

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

    public Set<BookDto> getBooks() {
        return books;
    }

    public void setBooks(Set<BookDto> books) {
        this.books = books;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}

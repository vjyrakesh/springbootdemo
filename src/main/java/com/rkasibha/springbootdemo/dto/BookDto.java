package com.rkasibha.springbootdemo.dto;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class BookDto {

    @NotBlank(message="Book name is mandatory")
    private String name;

    private List<ReviewDto> reviews;

//    @Valid
//    private AuthorDto author;

    public BookDto() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ReviewDto> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewDto> reviews) {
        this.reviews = reviews;
    }

    //    public AuthorDto getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(AuthorDto author) {
//        this.author = author;
//    }
}

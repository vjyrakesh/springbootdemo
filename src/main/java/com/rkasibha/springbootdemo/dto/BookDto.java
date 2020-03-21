package com.rkasibha.springbootdemo.dto;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;

public class BookDto {

    private Integer id;

    @NotBlank(message="Book name is mandatory")
    private String name;

    private List<ReviewDto> reviews;

    private Set<AuthorDto> authors;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<AuthorDto> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<AuthorDto> authors) {
        this.authors = authors;
    }
}

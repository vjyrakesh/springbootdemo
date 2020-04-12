package com.rkasibha.rentabook.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class BookDto {

    private Integer id;

    @NotBlank(message="Book name is mandatory")
    private String name;

    private List<ReviewDto> reviews = new ArrayList<>();

//    @JsonManagedReference
//    private Set<AuthorDto> authors = new HashSet<>();

    private Set<BookAuthorInfoDto> authorInfo = new HashSet<>();

//    @JsonIgnore
//    private Set<BookPublisherDto> publishers;

    private Set<PublisherInfoDto> publisherInfo = new HashSet<>();

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

//    public Set<AuthorDto> getAuthors() {
//        return authors;
//    }

//    public void setAuthors(Set<AuthorDto> authors) {
//        this.authors = authors;
//    }

//    public Set<BookPublisherDto> getPublishers() {
//        return publishers;
//    }

//    public void setPublishers(Set<BookPublisherDto> publishers) {
//        this.publishers = publishers;
//    }

    public Set<PublisherInfoDto> getPublisherInfo() {
        return publisherInfo;
    }

    public void setPublisherInfo(Set<PublisherInfoDto> publisherInfo) {
        this.publisherInfo = publisherInfo;
    }

    public Set<BookAuthorInfoDto> getAuthorInfo() {
        return authorInfo;
    }

    public void setAuthorInfo(Set<BookAuthorInfoDto> authorInfo) {
        this.authorInfo = authorInfo;
    }
}

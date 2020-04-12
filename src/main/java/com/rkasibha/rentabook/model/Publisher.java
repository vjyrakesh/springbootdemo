package com.rkasibha.rentabook.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<BookPublisher> publishedBooks = new HashSet<>();

    public Publisher() {
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

    public Set<BookPublisher> getPublishedBooks() {
        return publishedBooks;
    }

    public void setPublishedBooks(Set<BookPublisher> publishedBooks) {
        this.publishedBooks = publishedBooks;
    }
}

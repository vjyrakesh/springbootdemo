package com.rkasibha.springbootdemo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String content;

    @OneToMany(mappedBy = "review")
    private List<ReviewComment> reviewComments;

    public Review() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<ReviewComment> getReviewComments() {
        return reviewComments;
    }

    public void setReviewComments(List<ReviewComment> reviewComments) {
        this.reviewComments = reviewComments;
    }
}

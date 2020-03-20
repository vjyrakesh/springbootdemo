package com.rkasibha.springbootdemo.dto;

import java.util.List;

public class ReviewDto {

    private Integer id;
    private String content;
    private List<ReviewCommentDto> comments;

    public ReviewDto() {}

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

    public List<ReviewCommentDto> getComments() {
        return comments;
    }

    public void setComments(List<ReviewCommentDto> comments) {
        this.comments = comments;
    }
}

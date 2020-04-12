package com.rkasibha.rentabook.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BookPublisherId implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer bookId;
    private Integer publisherId;

    public BookPublisherId() {
    }

    public BookPublisherId(Integer bookId, Integer publisherId) {
        super();
        this.bookId = bookId;
        this.publisherId = publisherId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookPublisherId that = (BookPublisherId) o;
        return Objects.equals(bookId, that.bookId) &&
                Objects.equals(publisherId, that.publisherId);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((bookId == null) ? 0 : bookId.hashCode());
        result = prime * result
                + ((publisherId == null) ? 0 : publisherId.hashCode());
        return result;
    }
}

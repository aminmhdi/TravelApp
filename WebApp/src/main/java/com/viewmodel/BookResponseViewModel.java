package com.viewmodel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BookResponseViewModel {
    // Constructor with @JsonCreator
    @JsonCreator
    public BookResponseViewModel(@JsonProperty("bookId") Integer bookId) {
        this.bookId = bookId;
    }

    private Integer bookId;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }
}

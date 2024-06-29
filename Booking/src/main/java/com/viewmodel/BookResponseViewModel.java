package com.viewmodel;

public class BookResponseViewModel {

	public BookResponseViewModel(Integer bookId) {
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

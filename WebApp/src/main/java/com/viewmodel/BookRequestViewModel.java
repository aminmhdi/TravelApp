package com.viewmodel;

public class BookRequestViewModel {

	public BookRequestViewModel() {
	}

	public BookRequestViewModel(String email, Integer cabId) {
		this.email = email;
		this.cabId = cabId;
	}

	private String email;
	private Integer cabId;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getCabId() {
		return cabId;
	}

	public void setCabId(Integer cabId) {
		this.cabId = cabId;
	}
}

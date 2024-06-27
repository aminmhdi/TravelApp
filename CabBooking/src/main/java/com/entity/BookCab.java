package com.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity
public class BookCab {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true)
	private String email;
	private int cabId;
	private LocalDateTime createdDate;
	private LocalDateTime finishedDate;

	public BookCab() {
	}

	public BookCab(int id, String email, int cabId, LocalDateTime createdDate, LocalDateTime finishedDate) {
		this.id = id;
		this.email = email;
		this.cabId = cabId;
		this.createdDate = createdDate;
		this.finishedDate = finishedDate;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCabId() {
		return this.cabId;
	}

	public void setCabId(int cabId) {
		this.cabId = cabId;
	}

	public LocalDateTime getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getFinishedDate() {
		return this.finishedDate;
	}

	public void setFinishedDate(LocalDateTime finishedDate) {
		this.finishedDate = finishedDate;
	}

	public BookCab id(int id) {
		setId(id);
		return this;
	}

	public BookCab email(String email) {
		setEmail(email);
		return this;
	}

	public BookCab cabId(int cabId) {
		setCabId(cabId);
		return this;
	}

	public BookCab createdDate(LocalDateTime createdDate) {
		setCreatedDate(createdDate);
		return this;
	}

	public BookCab finishedDate(LocalDateTime finishedDate) {
		setFinishedDate(finishedDate);
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof BookCab)) {
			return false;
		}
		BookCab bookCab = (BookCab) o;
		return id == bookCab.id && Objects.equals(email, bookCab.email) && cabId == bookCab.cabId
				&& Objects.equals(createdDate, bookCab.createdDate)
				&& Objects.equals(finishedDate, bookCab.finishedDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, email, cabId, createdDate, finishedDate);
	}

	@Override
	public String toString() {
		return "{" +
				" id='" + getId() + "'" +
				", email='" + getEmail() + "'" +
				", cabId='" + getCabId() + "'" +
				", createdDate='" + getCreatedDate() + "'" +
				", finishedDate='" + getFinishedDate() + "'" +
				"}";
	}
}

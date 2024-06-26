package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BookCab {
	@Id
	private int bcid;
	@Column(unique = true)
	private String email;
	private String from;
	private String to;
	private int cabType;

	public int getBcid() {
		return bcid;
	}

	public void setBcid(int bcid) {
		this.bcid = bcid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public int getCabType() {
		return cabType;
	}

	public void setCabType(int cabType) {
		this.cabType = cabType;
	}
}

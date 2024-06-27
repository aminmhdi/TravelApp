package com.viewmodel;

import java.util.Objects;

public class CabViewModel extends CabRequestViewModel {
	private int id;
	private boolean isAvailable;

	public CabViewModel() {
	}

	public CabViewModel(int id, boolean isAvailable) {
		this.id = id;
		this.isAvailable = isAvailable;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isIsAvailable() {
		return this.isAvailable;
	}

	public boolean getIsAvailable() {
		return this.isAvailable;
	}

	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public CabViewModel id(int id) {
		setId(id);
		return this;
	}

	public CabViewModel isAvailable(boolean isAvailable) {
		setIsAvailable(isAvailable);
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof CabViewModel)) {
			return false;
		}
		CabViewModel cabResponseViewModel = (CabViewModel) o;
		return id == cabResponseViewModel.id && isAvailable == cabResponseViewModel.isAvailable;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, isAvailable);
	}

	@Override
	public String toString() {
		return "{" +
				" id='" + getId() + "'" +
				", isAvailable='" + isIsAvailable() + "'" +
				"}";
	}
}

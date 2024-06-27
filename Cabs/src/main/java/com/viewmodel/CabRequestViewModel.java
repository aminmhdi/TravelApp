package com.viewmodel;

import java.util.Objects;

public class CabRequestViewModel {
	private String driverName;
	private int type;
	private String from;
	private String to;
	private long amount;

	public CabRequestViewModel() {
	}

	public CabRequestViewModel(String driverName, int type, String from, String to, long amount) {
		this.driverName = driverName;
		this.type = type;
		this.from = from;
		this.to = to;
		this.amount = amount;
	}

	public String getDriverName() {
		return this.driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getFrom() {
		return this.from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return this.to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public long getAmount() {
		return this.amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public CabRequestViewModel driverName(String driverName) {
		setDriverName(driverName);
		return this;
	}

	public CabRequestViewModel type(int type) {
		setType(type);
		return this;
	}

	public CabRequestViewModel from(String from) {
		setFrom(from);
		return this;
	}

	public CabRequestViewModel to(String to) {
		setTo(to);
		return this;
	}

	public CabRequestViewModel amount(long amount) {
		setAmount(amount);
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof CabRequestViewModel)) {
			return false;
		}
		CabRequestViewModel cabRequestViewModel = (CabRequestViewModel) o;
		return Objects.equals(driverName, cabRequestViewModel.driverName) && type == cabRequestViewModel.type
				&& Objects.equals(from, cabRequestViewModel.from) && Objects.equals(to, cabRequestViewModel.to)
				&& amount == cabRequestViewModel.amount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(driverName, type, from, to, amount);
	}

	@Override
	public String toString() {
		return "{" +
				" driverName='" + getDriverName() + "'" +
				", type='" + getType() + "'" +
				", from='" + getFrom() + "'" +
				", to='" + getTo() + "'" +
				", amount='" + getAmount() + "'" +
				"}";
	}

}

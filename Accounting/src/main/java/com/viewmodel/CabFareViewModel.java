package com.viewmodel;

import java.util.Objects;

public class CabFareViewModel {
    private int id;
    private String driverName;
    private long fare;

    public CabFareViewModel() {
    }

    public CabFareViewModel(int id, String driverName, long fare) {
        this.id = id;
        this.driverName = driverName;
        this.fare = fare;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDriverName() {
        return this.driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public long getFare() {
        return this.fare;
    }

    public void setFare(long fare) {
        this.fare = fare;
    }

    public CabFareViewModel id(int id) {
        setId(id);
        return this;
    }

    public CabFareViewModel driverName(String driverName) {
        setDriverName(driverName);
        return this;
    }

    public CabFareViewModel fare(long fare) {
        setFare(fare);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CabFareViewModel)) {
            return false;
        }
        CabFareViewModel cabFareViewModel = (CabFareViewModel) o;
        return id == cabFareViewModel.id && Objects.equals(driverName, cabFareViewModel.driverName)
                && fare == cabFareViewModel.fare;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, driverName, fare);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", driverName='" + getDriverName() + "'" +
                ", fare='" + getFare() + "'" +
                "}";
    }
}
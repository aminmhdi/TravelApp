package com.viewmodel;

public class FareViewModel {
    private int id;
    private String driverName;
    private long fare;

    public FareViewModel() {
    }

    public FareViewModel(int id, String driverName, long fare) {
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

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", driverName='" + getDriverName() + "'" +
                ", fare='" + getFare() + "'" +
                "}";
    }
}
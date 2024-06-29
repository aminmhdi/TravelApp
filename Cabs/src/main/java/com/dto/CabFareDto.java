package com.dto;

import java.util.Objects;

public class CabFareDto {
    private int id;
    private String driverName;
    private long fare;

    public CabFareDto() {
    }

    public CabFareDto(int id, String driverName, long fare) {
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

    public CabFareDto id(int id) {
        setId(id);
        return this;
    }

    public CabFareDto driverName(String driverName) {
        setDriverName(driverName);
        return this;
    }

    public CabFareDto fare(long fare) {
        setFare(fare);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CabFareDto)) {
            return false;
        }
        CabFareDto cabFareDto = (CabFareDto) o;
        return id == cabFareDto.id && Objects.equals(driverName, cabFareDto.driverName) && fare == cabFareDto.fare;
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
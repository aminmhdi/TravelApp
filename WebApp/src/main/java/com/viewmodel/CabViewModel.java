package com.viewmodel;

import java.util.Objects;

public class CabViewModel {
    private int id;
    private String driverName;
    private int type;
    private String cabFrom;
    private String cabTo;
    private long amount;
    private boolean isAvailable;

    public CabViewModel() {
    }

    public CabViewModel(int id, String driverName, int type, String cabFrom, String cabTo, long amount,
            boolean isAvailable) {
        this.id = id;
        this.driverName = driverName;
        this.type = type;
        this.cabFrom = cabFrom;
        this.cabTo = cabTo;
        this.amount = amount;
        this.isAvailable = isAvailable;
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

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCabFrom() {
        return this.cabFrom;
    }

    public void setCabFrom(String cabFrom) {
        this.cabFrom = cabFrom;
    }

    public String getCabTo() {
        return this.cabTo;
    }

    public void setCabTo(String cabTo) {
        this.cabTo = cabTo;
    }

    public long getAmount() {
        return this.amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
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

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CabViewModel)) {
            return false;
        }
        CabViewModel cab = (CabViewModel) o;
        return id == cab.id && Objects.equals(driverName, cab.driverName) && type == cab.type
                && Objects.equals(cabFrom, cab.cabFrom) && Objects.equals(cabTo, cab.cabTo) && amount == cab.amount
                && isAvailable == cab.isAvailable;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, driverName, type, cabFrom, cabTo, amount, isAvailable);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", driverName='" + getDriverName() + "'" +
                ", type='" + getType() + "'" +
                ", cabFrom='" + getCabFrom() + "'" +
                ", cabTo='" + getCabTo() + "'" +
                ", amount='" + getAmount() + "'" +
                ", isAvailable='" + isIsAvailable() + "'" +
                "}";
    }
}

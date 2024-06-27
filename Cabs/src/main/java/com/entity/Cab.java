package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity
public class Cab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false)
    private String driverName;
    @Column(nullable = false)
    private int type;
    @Column(nullable = false)
    private String cabFrom;
    @Column(nullable = false)
    private String cabTo;
    @Column(nullable = false)
    private long amount;
    @Column(nullable = false)
    private boolean isAvailable;

    public Cab() {
    }

    public Cab(int id, String driverName, int type, String cabFrom, String cabTo, long amount, boolean isAvailable) {
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

    public Cab id(int id) {
        setId(id);
        return this;
    }

    public Cab driverName(String driverName) {
        setDriverName(driverName);
        return this;
    }

    public Cab type(int type) {
        setType(type);
        return this;
    }

    public Cab cabFrom(String cabFrom) {
        setCabFrom(cabFrom);
        return this;
    }

    public Cab cabTo(String cabTo) {
        setCabTo(cabTo);
        return this;
    }

    public Cab amount(long amount) {
        setAmount(amount);
        return this;
    }

    public Cab isAvailable(boolean isAvailable) {
        setIsAvailable(isAvailable);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Cab)) {
            return false;
        }
        Cab cab = (Cab) o;
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

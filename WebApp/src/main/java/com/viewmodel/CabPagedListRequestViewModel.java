package com.viewmodel;

import java.util.Objects;

public class CabPagedListRequestViewModel {
    public String from;
    public String to;
    public Integer type;
    public Long amountFrom;
    public Long amountTo;
    public Boolean isAvailable;

    public int pageNumber;
    public int pageSize;
    public String orderBy;
    public String order;

    public CabPagedListRequestViewModel() {
    }

    public CabPagedListRequestViewModel(String from, String to, Integer type, Long amountFrom, Long amountTo,
            Boolean isAvailable, int pageNumber,
            int pageSize, String orderBy, String order) {
        this.from = from;
        this.to = to;
        this.type = type;
        this.amountFrom = amountFrom;
        this.amountTo = amountTo;
        this.isAvailable = isAvailable;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.orderBy = orderBy;
        this.order = order;
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

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getAmountFrom() {
        return this.amountFrom;
    }

    public void setAmountFrom(Long amountFrom) {
        this.amountFrom = amountFrom;
    }

    public Long getAmountTo() {
        return this.amountTo;
    }

    public void setAmountTo(Long amountTo) {
        this.amountTo = amountTo;
    }

    public Boolean getIsAvailable() {
        return this.isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public int getPageNumber() {
        return this.pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderBy() {
        return this.orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getOrder() {
        return this.order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CabPagedListRequestViewModel)) {
            return false;
        }
        CabPagedListRequestViewModel cabPagedListRequestDto = (CabPagedListRequestViewModel) o;
        return Objects.equals(from, cabPagedListRequestDto.from) && Objects.equals(to, cabPagedListRequestDto.to)
                && type == cabPagedListRequestDto.type && amountFrom == cabPagedListRequestDto.amountFrom
                && amountTo == cabPagedListRequestDto.amountTo && pageNumber == cabPagedListRequestDto.pageNumber
                && pageSize == cabPagedListRequestDto.pageSize
                && Objects.equals(orderBy, cabPagedListRequestDto.orderBy)
                && Objects.equals(order, cabPagedListRequestDto.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, type, amountFrom, amountTo, pageNumber, pageSize, orderBy, order);
    }

    @Override
    public String toString() {
        return "{" +
                " from='" + getFrom() + "'" +
                ", to='" + getTo() + "'" +
                ", type='" + getType() + "'" +
                ", amountFrom='" + getAmountFrom() + "'" +
                ", amountTo='" + getAmountTo() + "'" +
                ", pageNumber='" + getPageNumber() + "'" +
                ", pageSize='" + getPageSize() + "'" +
                ", orderBy='" + getOrderBy() + "'" +
                ", order='" + getOrder() + "'" +
                "}";
    }
}
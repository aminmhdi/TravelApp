package com.dto;

import java.util.List;

import com.entity.Cab;
import java.util.Objects;

public class CabPagedListResponseDto {
    public List<Cab> list;
    public int totalPages;

    public CabPagedListResponseDto() {
    }

    public CabPagedListResponseDto(List<Cab> list, int total) {
        this.list = list;
        this.totalPages = total;
    }

    public List<Cab> getList() {
        return this.list;
    }

    public void setList(List<Cab> list) {
        this.list = list;
    }

    public int getTotalPages() {
        return this.totalPages;
    }

    public void setTotalPages(int total) {
        this.totalPages = total;
    }

    public CabPagedListResponseDto list(List<Cab> list) {
        setList(list);
        return this;
    }

    public CabPagedListResponseDto total(int total) {
        setTotalPages(total);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CabPagedListResponseDto)) {
            return false;
        }
        CabPagedListResponseDto cabPagedListResponseDto = (CabPagedListResponseDto) o;
        return Objects.equals(list, cabPagedListResponseDto.list) && totalPages == cabPagedListResponseDto.totalPages;
    }

    @Override
    public int hashCode() {
        return Objects.hash(list, totalPages);
    }

    @Override
    public String toString() {
        return "{" +
                " list='" + getList() + "'" +
                ", total='" + getTotalPages() + "'" +
                "}";
    }
}

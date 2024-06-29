package com.viewmodel;

import java.util.Objects;

public class CabUpdateRequestViewModel {
    private Integer id;
    private Boolean isAvailable;

    public CabUpdateRequestViewModel() {
    }

    public CabUpdateRequestViewModel(Integer id, Boolean isAvailable) {
        this.id = id;
        this.isAvailable = isAvailable;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean isIsAvailable() {
        return this.isAvailable;
    }

    public Boolean getIsAvailable() {
        return this.isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public CabUpdateRequestViewModel id(int id) {
        setId(id);
        return this;
    }

    public CabUpdateRequestViewModel isAvailable(Boolean isAvailable) {
        setIsAvailable(isAvailable);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CabUpdateRequestViewModel)) {
            return false;
        }
        CabUpdateRequestViewModel cabUpdateRequestViewModel = (CabUpdateRequestViewModel) o;
        return id == cabUpdateRequestViewModel.id && isAvailable == cabUpdateRequestViewModel.isAvailable;
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

package com.viewmodel;

import java.time.LocalDateTime;

public class BookViewModel {
    private int id;
    private String email;
    private int cabId;
    private LocalDateTime createdDate;
    private LocalDateTime finishedDate;

    public BookViewModel() {
    }

    public BookViewModel(int id, String email, int cabId, LocalDateTime createdDate, LocalDateTime finishedDate) {
        this.id = id;
        this.email = email;
        this.cabId = cabId;
        this.createdDate = createdDate;
        this.finishedDate = finishedDate;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCabId() {
        return this.cabId;
    }

    public void setCabId(int cabId) {
        this.cabId = cabId;
    }

    public LocalDateTime getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getFinishedDate() {
        return this.finishedDate;
    }

    public void setFinishedDate(LocalDateTime finishedDate) {
        this.finishedDate = finishedDate;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", email='" + getEmail() + "'" +
                ", cabId='" + getCabId() + "'" +
                ", createdDate='" + getCreatedDate() + "'" +
                ", finishedDate='" + getFinishedDate() + "'" +
                "}";
    }
}

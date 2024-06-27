package com.viewmodel;

import java.util.List;

public class CabPagedListViewModel {
    private List<CabViewModel> list;
    private int totalPages;

    public List<CabViewModel> getList() {
        return this.list;
    }

    public void setList(List<CabViewModel> list) {
        this.list = list;
    }

    public int getTotalPages() {
        return this.totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public CabPagedListViewModel(List<CabViewModel> list, int totalPages) {
        this.list = list;
        this.totalPages = totalPages;
    }
}
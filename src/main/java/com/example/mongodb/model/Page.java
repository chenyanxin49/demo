package com.example.mongodb.model;

import lombok.Data;

import java.util.List;

@Data
public class Page<T> {

    private long total;
    private int pageNumber;
    private int pageSize;
    private List<T> rows;

    public Page(int pageNumber, int pageSize) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }
}

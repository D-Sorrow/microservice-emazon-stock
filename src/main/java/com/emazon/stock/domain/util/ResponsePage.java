package com.emazon.stock.domain.util;

import java.util.List;

public class ResponsePage<T>{
    private Integer size;
    private Integer pages;
    private String sortBy;
    private List<T> collection;

    public ResponsePage(Integer size, Integer pages, String sortBy, List<T> collection) {
        this.size = size;
        this.pages = pages;
        this.sortBy = sortBy;
        this.collection = collection;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public List<T> getCollection() {
        return collection;
    }

    public void setCollection(List<T> collection) {
        this.collection = collection;
    }
}

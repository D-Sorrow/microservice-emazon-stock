package com.emazon.stock.domain.util;

import java.util.List;

public class ResponsePage<T>{
    private Integer size;
    private Integer pages;
    private List<T> collection;

    public ResponsePage(Integer size, Integer pages, List<T> collection) {
        this.size = size;
        this.pages = pages;
        this.collection = collection;
    }

    public List<T> getCollection() {
        return collection;
    }

    public void setCollection(List<T> collection) {
        this.collection = collection;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}

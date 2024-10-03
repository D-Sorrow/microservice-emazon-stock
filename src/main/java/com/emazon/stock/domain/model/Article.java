package com.emazon.stock.domain.model;

import java.math.BigDecimal;
import java.util.List;
public class Article {

    private Long idArticle;
    private String nameArticle;
    private String descriptionArticle;
    private Integer stock;
    private BigDecimal price;
    private Brand brand;
    private List<Category> categories;

    public Article(Long idArticle, String nameArticle, String descriptionArticle, Integer stock, BigDecimal price, Brand brand, List<Category> categories) {
        this.idArticle = idArticle;
        this.nameArticle = nameArticle;
        this.descriptionArticle = descriptionArticle;
        this.stock = stock;
        this.price = price;
        this.brand = brand;
        this.categories = categories;
    }
    public Article() {}

    public Long getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Long idArticle) {
        this.idArticle = idArticle;
    }

    public String getNameArticle() {
        return nameArticle;
    }

    public void setNameArticle(String nameArticle) {
        this.nameArticle = nameArticle;
    }

    public String getDescriptionArticle() {
        return descriptionArticle;
    }

    public void setDescriptionArticle(String descriptionArticle) {
        this.descriptionArticle = descriptionArticle;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}

package com.emazon.stock.domain.model;

public class Brand {

    private Long brandId;
    private String brandName;
    private String brandDescription;

    public Brand(Long brandId, String brandName, String brandDescription) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.brandDescription = brandDescription;
    }

    public Brand() {

    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getBrandDescription() {
        return brandDescription;
    }

    public void setBrandDescription(String brandDescription) {
        this.brandDescription = brandDescription;
    }
}

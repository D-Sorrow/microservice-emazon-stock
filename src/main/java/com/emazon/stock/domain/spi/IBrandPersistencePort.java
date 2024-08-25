package com.emazon.stock.domain.spi;

import com.emazon.stock.domain.model.Brand;

import java.util.List;

public interface IBrandPersistencePort {

    void saveBrand(Brand brand);

    List<Brand> getAllBrands();

    Brand getBrand(String brandId);

    void deleteBrand(String brandId);

    void updateBrand(Brand brand);
}

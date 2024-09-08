package com.emazon.stock.domain.api;

import com.emazon.stock.domain.model.Brand;
import com.emazon.stock.domain.model.Category;
import com.emazon.stock.domain.util.ResponsePage;

import java.util.List;

public interface IBrandServicePort {

    void saveBrand(Brand brand);

    ResponsePage<Brand> getAllBrands(Integer page, Integer size, String sortDirection);

    Brand getBrand(String brandId);

    void deleteBrand(String brandId);

    void updateBrand(Brand brand);

}

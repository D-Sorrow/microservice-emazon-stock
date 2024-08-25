package com.emazon.stock.domain.api.usecase;

import com.emazon.stock.domain.api.IBrandServicePort;
import com.emazon.stock.domain.model.Brand;
import com.emazon.stock.domain.spi.IBrandPersistencePort;

import java.util.List;


public class BrandUseCase  implements IBrandServicePort {

    private final IBrandPersistencePort brandPersistencePort;

    public BrandUseCase(IBrandPersistencePort brandPersistencePort) {
        this.brandPersistencePort = brandPersistencePort;
    }
    @Override
    public void saveBrand(Brand brand) {
        if (brand.getBrandDescription() == null || brand.getBrandName() == null) {
            throw new IllegalArgumentException("Category cannot be null");
        }
        if(brand.getBrandDescription().isEmpty() || brand.getBrandName().isEmpty()) {
            throw new IllegalArgumentException("Category cannot be empty");
        }
        this.brandPersistencePort.saveBrand(brand);

    }

    @Override
    public List<Brand> getAllBrands(Integer page, Integer size, String sortDirection) {
        return this.brandPersistencePort.getAllBrands(page, size, sortDirection);
    }

    @Override
    public Brand getBrand(String brandId) {
        return null;
    }

    @Override
    public void deleteBrand(String brandId) {

    }

    @Override
    public void updateBrand(Brand brand) {

    }
}

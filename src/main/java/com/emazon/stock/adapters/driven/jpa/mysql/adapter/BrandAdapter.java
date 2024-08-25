package com.emazon.stock.adapters.driven.jpa.mysql.adapter;

import com.emazon.stock.adapters.driven.jpa.mysql.exception.BrandAlreadyExistException;
import com.emazon.stock.adapters.driven.jpa.mysql.mapper.IBrandEntityMapper;
import com.emazon.stock.adapters.driven.jpa.mysql.repository.IBrandRepository;
import com.emazon.stock.domain.model.Brand;
import com.emazon.stock.domain.spi.IBrandPersistencePort;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RequiredArgsConstructor
public class BrandAdapter implements IBrandPersistencePort {

    private final IBrandRepository brandRepository;
    private final IBrandEntityMapper brandEntityMapper;

    @Override
    public void saveBrand(Brand brand) {
        if(this.brandRepository.findBybrandName(brand.getBrandName()).isPresent()){
            throw new BrandAlreadyExistException(brand.getBrandName() + "is already exist");
        }
        this.brandRepository.save(brandEntityMapper.toBrandEntity(brand));
    }

    @Override
    public List<Brand> getAllBrands() {
        return List.of();
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

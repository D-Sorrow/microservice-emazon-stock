package com.emazon.stock.adapters.driven.jpa.mysql.adapter;

import com.emazon.stock.adapters.driven.jpa.mysql.constants.ConstantsJpa;
import com.emazon.stock.adapters.driven.jpa.mysql.entity.BrandEntity;
import com.emazon.stock.adapters.driven.jpa.mysql.exception.BrandAlreadyExistException;
import com.emazon.stock.adapters.driven.jpa.mysql.exception.ElementNotFoundException;
import com.emazon.stock.adapters.driven.jpa.mysql.mapper.IBrandEntityMapper;
import com.emazon.stock.adapters.driven.jpa.mysql.repository.IBrandRepository;
import com.emazon.stock.domain.model.Brand;
import com.emazon.stock.domain.spi.IBrandPersistencePort;
import com.emazon.stock.domain.util.ResponsePage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@RequiredArgsConstructor
public class BrandAdapter implements IBrandPersistencePort {

    private final IBrandRepository brandRepository;
    private final IBrandEntityMapper brandEntityMapper;

    @Override
    public void saveBrand(Brand brand) {
        if(this.brandRepository.findBybrandName(brand.getBrandName()).isPresent()){
            throw new BrandAlreadyExistException();
        }
        this.brandRepository.save(brandEntityMapper.toBrandEntity(brand));
    }

    @Override
    public ResponsePage<Brand> getAllBrands(Integer page, Integer size, String sortDirection) {
        Sort.Direction direction = Sort.Direction.fromString(sortDirection.toUpperCase());
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, ConstantsJpa.DIRECTION_BRAND));
        List<BrandEntity> brandEntities = brandRepository.findAll(pageable).getContent();
        if(brandEntities.isEmpty()){
            throw new ElementNotFoundException();
        }
        return new ResponsePage<>(
                size,
                page,
                brandEntityMapper.toBrandEntities(brandEntities)
        );
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

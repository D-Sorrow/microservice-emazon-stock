package com.emazon.stock.domain.api.usecase;

import com.emazon.stock.domain.api.IBrandServicePort;
import com.emazon.stock.domain.model.Brand;
import com.emazon.stock.domain.spi.IBrandPersistencePort;
import com.emazon.stock.domain.util.ResponsePage;

import java.util.regex.Pattern;

import static com.emazon.stock.domain.constants.ConstantsDomain.CONTROLLER_REGULAR_EXPRESSION_SORT_DIRECTION;
import static com.emazon.stock.domain.constants.ConstantsDomain.CONTROLLER_SIZE_INVALID_PAGEABLE;


public class BrandUseCase  implements IBrandServicePort {

    private final IBrandPersistencePort brandPersistencePort;

    public BrandUseCase(IBrandPersistencePort brandPersistencePort) {
        this.brandPersistencePort = brandPersistencePort;
    }
    @Override
    public void saveBrand(Brand brand) {
        if (brand.getBrandDescription() == null || brand.getBrandName() == null) {
            throw new IllegalArgumentException();
        }
        if(brand.getBrandDescription().isEmpty() || brand.getBrandName().isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.brandPersistencePort.saveBrand(brand);

    }

    @Override
    public ResponsePage<Brand> getAllBrands(Integer page, Integer size, String sortDirection) {
        Pattern patternSort = Pattern.compile(CONTROLLER_REGULAR_EXPRESSION_SORT_DIRECTION);

        if(!patternSort.matcher(sortDirection).find()){
            throw new IllegalArgumentException();
        }
        if (page < CONTROLLER_SIZE_INVALID_PAGEABLE || size < CONTROLLER_SIZE_INVALID_PAGEABLE) {
            throw new IllegalArgumentException();
        }
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

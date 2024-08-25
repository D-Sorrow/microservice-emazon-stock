package com.emazon.stock.domain.api.usecase;

import com.emazon.stock.DataProviderBrand;
import com.emazon.stock.adapters.driven.jpa.mysql.adapter.BrandAdapter;
import com.emazon.stock.domain.model.Brand;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BrandUseCaseTest {

    @Mock
    private BrandAdapter brandAdapter;

    @InjectMocks
    private BrandUseCase brandUseCase;


    @Test
    void saveBrand() {
        this.brandUseCase.saveBrand(DataProviderBrand.brandMock());

        ArgumentCaptor<Brand> brandCaptor = ArgumentCaptor.forClass(Brand.class);

        verify(this.brandAdapter).saveBrand(brandCaptor.capture());

        assertEquals(DataProviderBrand.brandMock().getBrandId(), brandCaptor.getValue().getBrandId());
        assertEquals(DataProviderBrand.brandMock().getBrandName(), brandCaptor.getValue().getBrandName());
        assertEquals(DataProviderBrand.brandMock().getBrandDescription(), brandCaptor.getValue().getBrandDescription());

    }

    @Test
    void getAllBrands() {

        when(brandAdapter.getAllBrands(DataProviderBrand.pageableMock().getPageNumber(),
                DataProviderBrand.pageableMock().getPageSize(), "ASC")).thenReturn(DataProviderBrand.brandListMock());
        List<Brand> brands = brandUseCase.getAllBrands(DataProviderBrand.pageableMock().getPageNumber(),
                DataProviderBrand.pageableMock().getPageSize(), "ASC");

        assertNotNull(brands);
        assertFalse(brands.isEmpty());
        assertEquals(DataProviderBrand.brandMock().getBrandName(), brands.get(0).getBrandName());
    }
}
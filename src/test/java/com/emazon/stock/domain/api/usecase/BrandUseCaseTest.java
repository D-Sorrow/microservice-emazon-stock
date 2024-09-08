package com.emazon.stock.domain.api.usecase;

import com.emazon.stock.constants.DataProviderBrand;
import com.emazon.stock.constants.DataProviderPage;
import com.emazon.stock.adapters.driven.jpa.mysql.adapter.BrandAdapter;
import com.emazon.stock.domain.model.Brand;
import com.emazon.stock.domain.util.ResponsePage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;


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
                DataProviderBrand.pageableMock().getPageSize(), "ASC")).thenReturn(DataProviderPage.responsePageBrandMock());
        ResponsePage<Brand> brandResponsePage = brandUseCase.getAllBrands(DataProviderBrand.pageableMock().getPageNumber(),
                DataProviderBrand.pageableMock().getPageSize(), "ASC");

        assertNotNull(brandResponsePage);
        assertFalse(brandResponsePage.getCollection().isEmpty());
        assertNotNull(brandResponsePage.getPages());
        assertNotNull(brandResponsePage.getSize());
        assertEquals(DataProviderBrand.brandMock().getBrandName(), brandResponsePage.getCollection().get(0).getBrandName());
    }
}
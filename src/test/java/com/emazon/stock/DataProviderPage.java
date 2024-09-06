package com.emazon.stock;

import com.emazon.stock.domain.util.ResponsePage;

public class DataProviderPage {

    public static ResponsePage responsePageCategoryMock(){
        return new ResponsePage<>(
                7,
                0,
                DataProviderCategory.categoryListMock()
        );
    }
    public static ResponsePage responsePageBrandMock(){
        return new ResponsePage<>(
                7,
                0,
                DataProviderBrand.brandListMock()
        );
    }

}

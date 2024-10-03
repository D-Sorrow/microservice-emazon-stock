package com.emazon.stock.constants;

import com.emazon.stock.domain.util.ResponsePage;

public class DataProviderPage {

    private DataProviderPage(){};


    public static ResponsePage responsePageCategoryMock(){
        return new ResponsePage<>(
                7,
                0,
                DataProviderCategory.NAME_CATEGORY,
                DataProviderCategory.categoryResponseMock()
        );
    }
    public static ResponsePage responsePageBrandMock(){
        return new ResponsePage<>(
                7,
                0,
                DataProviderCategory.BRAND_CATEGORY,
                DataProviderBrand.brandResponseList()
        );
    }


}

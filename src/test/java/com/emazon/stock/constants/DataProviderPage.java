package com.emazon.stock.constants;

import com.emazon.stock.domain.util.ResponsePage;

public class DataProviderPage {

    private DataProviderPage(){};


    public static ResponsePage responsePageCategoryMock(){
        return new ResponsePage<>(
                7,
                0,
                DataProviderCategory.categoryResponseMock()
        );
    }
    public static ResponsePage responsePageBrandMock(){
        return new ResponsePage<>(
                7,
                0,
                DataProviderBrand.brandResponseList()
        );
    }


}

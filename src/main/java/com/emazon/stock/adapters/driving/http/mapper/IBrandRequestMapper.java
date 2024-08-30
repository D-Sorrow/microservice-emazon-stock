package com.emazon.stock.adapters.driving.http.mapper;


import com.emazon.stock.adapters.driving.http.dto.request.AddBrandRequest;
import com.emazon.stock.domain.model.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static com.emazon.stock.adapters.driving.http.constants.ConstantsHttp.BRAND_ID;


@Mapper(componentModel = "spring")
public interface IBrandRequestMapper {


    @Mapping(target = BRAND_ID, ignore = true)
    Brand addRequestBrand(AddBrandRequest addBrandRequest);
    
}

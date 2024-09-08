package com.emazon.stock.adapters.driving.http.mapper;

import com.emazon.stock.adapters.driving.http.dto.response.BrandResponse;
import com.emazon.stock.domain.model.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IBrandResponseMapper {
    
    BrandResponse toBrandResponse(Brand brand);
    List<BrandResponse> toBrandResponseList(List<Brand> brands);
}

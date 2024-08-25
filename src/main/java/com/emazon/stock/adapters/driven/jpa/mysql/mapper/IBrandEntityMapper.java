package com.emazon.stock.adapters.driven.jpa.mysql.mapper;


import com.emazon.stock.adapters.driven.jpa.mysql.entity.BrandEntity;
import com.emazon.stock.domain.model.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IBrandEntityMapper {
    @Mapping(source = "brandId", target = "brandId")
    @Mapping(source = "brandName", target = "brandName")
    @Mapping(source = "brandDescription", target = "brandDescription")
    Brand toBrand(BrandEntity brandEntity);

    @Mapping(source = "brandId", target = "brandId")
    @Mapping(source = "brandName", target = "brandName")
    @Mapping(source = "brandDescription", target = "brandDescription")
    BrandEntity toBrandEntity(Brand brand);
    List<Brand> toBrandEntities(List<BrandEntity> brandsEntity);


}

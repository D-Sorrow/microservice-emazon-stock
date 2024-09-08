package com.emazon.stock.adapters.driven.jpa.mysql.mapper;


import com.emazon.stock.adapters.driven.jpa.mysql.constants.ConstantsJpa;
import com.emazon.stock.adapters.driven.jpa.mysql.entity.BrandEntity;
import com.emazon.stock.domain.model.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IBrandEntityMapper {
    @Mapping(source = ConstantsJpa.BRAND_ID, target = ConstantsJpa.BRAND_ID)
    @Mapping(source = ConstantsJpa.BRAND_NAME, target = ConstantsJpa.BRAND_NAME)
    @Mapping(source = ConstantsJpa.BRAND_DESCRIPTION, target = ConstantsJpa.BRAND_DESCRIPTION)
    Brand toBrand(BrandEntity brandEntity);

    @Mapping(source = ConstantsJpa.BRAND_ID, target = ConstantsJpa.BRAND_ID)
    @Mapping(source = ConstantsJpa.BRAND_NAME, target = ConstantsJpa.BRAND_NAME)
    @Mapping(source = ConstantsJpa.BRAND_DESCRIPTION, target = ConstantsJpa.BRAND_DESCRIPTION)
    BrandEntity toBrandEntity(Brand brand);
    List<Brand> toBrandEntities(List<BrandEntity> brandsEntity);


}

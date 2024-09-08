package com.emazon.stock.adapters.driven.jpa.mysql.mapper;

import com.emazon.stock.adapters.driven.jpa.mysql.constants.ConstantsJpa;
import com.emazon.stock.adapters.driven.jpa.mysql.entity.CategoryEntity;
import com.emazon.stock.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ICategoryEntityMapper {

    @Mapping(source = ConstantsJpa.ID_CATEGORY, target = ConstantsJpa.ID_CATEGORY)
    @Mapping(source = ConstantsJpa.NAME_CATEGORY, target = ConstantsJpa.NAME_CATEGORY)
    @Mapping(source = ConstantsJpa.DESCRIPTION_CATEGORY, target = ConstantsJpa.DESCRIPTION_CATEGORY)
    Category toCategory(CategoryEntity categoryEntity);

    @Mapping(source = ConstantsJpa.ID_CATEGORY, target = ConstantsJpa.ID_CATEGORY)
    @Mapping(source = ConstantsJpa.NAME_CATEGORY, target = ConstantsJpa.NAME_CATEGORY)
    @Mapping(source = ConstantsJpa.DESCRIPTION_CATEGORY, target = ConstantsJpa.DESCRIPTION_CATEGORY)
    @Mapping(target = "articles", ignore = true)
    CategoryEntity toCategoryEntity(Category category);
    List<Category> toCategoryList(List<CategoryEntity> categoryEntityList);

}

package com.emazon.stock.adapters.driven.jpa.mysql.mapper;

import com.emazon.stock.adapters.driven.jpa.mysql.entity.CategoryEntity;
import com.emazon.stock.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ICategoryEntityMapper {
    @Mapping(source = "idCategory", target = "idCategory")
    @Mapping(source = "nameCategory", target = "nameCategory")
    @Mapping(source = "descriptionCategory", target = "descriptionCategory")
    Category toCategory(CategoryEntity categoryEntity);

    @Mapping(source = "idCategory", target = "idCategory")
    @Mapping(source = "nameCategory", target = "nameCategory")
    @Mapping(source = "descriptionCategory", target = "descriptionCategory")
    CategoryEntity toCategoryEntity(Category category);
    List<Category> toCategoryList(List<CategoryEntity> categoryEntityList);

}

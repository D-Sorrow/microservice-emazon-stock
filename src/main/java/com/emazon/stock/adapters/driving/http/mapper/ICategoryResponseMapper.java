package com.emazon.stock.adapters.driving.http.mapper;


import com.emazon.stock.adapters.driving.http.dto.response.CategoryResponse;
import com.emazon.stock.domain.model.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICategoryResponseMapper {
    CategoryResponse toCategoryResponse(Category category);
    List<CategoryResponse> toCategoryResponsesList(List<Category> categories);

}

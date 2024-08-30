package com.emazon.stock.adapters.driving.http.mapper;

import com.emazon.stock.adapters.driving.http.dto.request.AddCategoryRequest;
import com.emazon.stock.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static com.emazon.stock.adapters.driving.http.constants.ConstantsHttp.ID_CATEGORY;

@Mapper(componentModel = "spring")
public interface ICategoryRequestMapper {


    @Mapping(target = ID_CATEGORY, ignore = true)
    Category addRequestToCategory(AddCategoryRequest addCategoryRequest);

}

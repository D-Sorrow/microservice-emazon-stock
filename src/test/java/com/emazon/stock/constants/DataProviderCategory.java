package com.emazon.stock.constants;


import com.emazon.stock.adapters.driving.http.dto.request.AddCategoryRequest;
import com.emazon.stock.adapters.driving.http.dto.response.CategoryResponse;
import com.emazon.stock.domain.model.Category;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public class DataProviderCategory {

    public static final String NAME_ARTICLE = "nameArticle";
    public static final String NAME_CATEGORY = "nameCategory";
    public static final String BRAND_CATEGORY = "nameBrand";


    public static List<Category> categoryListMock(){
        return List.of(
            new Category(1L, "Electronics", "Household appliances like refrigerators, washing machines, and microwaves."),
            new Category(5L, "Electronics", "Furniture for living rooms, bedrooms, and offices including sofas, beds, and desks."),
            new Category(6L, "Toys", "Toys and games for children of all ages."),
            new Category(7L, "Sports Equipment", "Equipment and gear for various sports including football, basketball, and tennis."),
            new Category(8L, "Groceries", "Everyday grocery items including fruits, vegetables, and snacks."),
            new Category(9L, "Beauty Products", "Cosmetics, skincare, and other beauty-related products."),
            new Category(10L, "Automotive", "Car parts, accessories, and tools for automotive maintenance and repair.")
        );
    }
    public static List<CategoryResponse> categoryResponseMock(){
        return List.of(
                new CategoryResponse(1L,"Electronics"),
                new CategoryResponse(2L, "Toys")
        );
    }

    public static Category categoryMock(){
        return new Category(2L, "Furniture", "Items related to electronic devices and gadgets.");
    }
    public static AddCategoryRequest addCategoryRequestMock(){
        return new AddCategoryRequest("Furniture", "Items related to electronic devices and gadgets.");
    }

    public static Pageable pageableMock(){
        return PageRequest.of(0,
                10,
                Sort.by(Sort.Direction.ASC,"nameCategory"));
    }
}

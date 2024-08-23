package com.emazon.stock;


import com.emazon.stock.domain.model.Category;

import java.util.List;

public class DataProviderCategory {

    public static List<Category> categoryListMock(){
        return List.of(
            new Category(1L, "Electronics", "Household appliances like refrigerators, washing machines, and microwaves."),
            new Category(5L, "Furniture", "Furniture for living rooms, bedrooms, and offices including sofas, beds, and desks."),
            new Category(6L, "Toys", "Toys and games for children of all ages."),
            new Category(7L, "Sports Equipment", "Equipment and gear for various sports including football, basketball, and tennis."),
            new Category(8L, "Groceries", "Everyday grocery items including fruits, vegetables, and snacks."),
            new Category(9L, "Beauty Products", "Cosmetics, skincare, and other beauty-related products."),
            new Category(10L, "Automotive", "Car parts, accessories, and tools for automotive maintenance and repair.")
        );
    }

    public static Category categoryMock(){
        return new Category(2L, "Furniture", "Items related to electronic devices and gadgets.");
    }
}

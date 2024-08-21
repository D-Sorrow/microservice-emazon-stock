package com.emazon.stock.domain.api;

import com.emazon.stock.domain.model.Category;

import java.util.List;

public interface ICategoryServicePort {

    void saveCategory(Category category);

    List<Category> getAllCategory();

    Category getCategoryById(Long idCategory);

    void updateCategory(Category category);

    void deleteCategoryById(Long idCategory);
}

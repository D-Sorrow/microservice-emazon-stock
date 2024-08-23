package com.emazon.stock.domain.spi;

import com.emazon.stock.domain.model.Category;

import java.util.List;

public interface ICategoryPersistencePort {

    void saveCategory(Category category);

    List<Category> getAllCategory();

    Category getCategoryById(Long idCategory);

    void updateCategory(Category category);

    void deleteCategoryById(Long idCategory);
}

package com.emazon.stock.domain.api;

import com.emazon.stock.domain.model.Category;
import com.emazon.stock.domain.util.ResponsePage;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryServicePort {

    void saveCategory(Category category);

    ResponsePage<Category> getAllCategory(Integer page, Integer size, String sortDirection);

    Category getCategoryById(Long idCategory);

    void updateCategory(Category category);

    void deleteCategoryById(Long idCategory);
}

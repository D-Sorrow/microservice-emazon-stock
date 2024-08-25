package com.emazon.stock.domain.api.usecase;

import com.emazon.stock.domain.api.ICategoryServicePort;
import com.emazon.stock.domain.model.Category;
import com.emazon.stock.domain.spi.ICategoryPersistencePort;

import java.util.List;

public class CategoryUseCase implements ICategoryServicePort {

    public final ICategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase(ICategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public void saveCategory(Category category) {
        if (category.getDescriptionCategory() == null || category.getNameCategory() == null) {
            throw new IllegalArgumentException("Category cannot be null");
        }
        if(category.getDescriptionCategory().isEmpty() || category.getNameCategory().isEmpty()) {
            throw new IllegalArgumentException("Category cannot be empty");
        }
        this.categoryPersistencePort.saveCategory(category);
    }

    @Override
    public List<Category> getAllCategory(Integer page, Integer size, String sortDirection) {
        return categoryPersistencePort.getAllCategory(page,size, sortDirection);
    }

    @Override
    public Category getCategoryById(Long idCategory) {
        return categoryPersistencePort.getCategoryById(idCategory);
    }

    @Override
    public void updateCategory(Category category) {
        this.categoryPersistencePort.updateCategory(category);
    }

    @Override
    public void deleteCategoryById(Long idCategory) {
        this.categoryPersistencePort.deleteCategoryById(idCategory);
    }
}

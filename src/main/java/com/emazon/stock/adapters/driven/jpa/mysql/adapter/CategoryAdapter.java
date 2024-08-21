package com.emazon.stock.adapters.driven.jpa.mysql.adapter;


import com.emazon.stock.adapters.driven.jpa.mysql.exception.CategoryAlreadyExistException;
import com.emazon.stock.adapters.driven.jpa.mysql.mapper.ICategoryEntityMapper;
import com.emazon.stock.adapters.driven.jpa.mysql.repository.ICategoryRepository;
import com.emazon.stock.domain.model.Category;
import com.emazon.stock.domain.spi.ICategoryPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CategoryAdapter implements ICategoryPersistencePort {

    private final ICategoryRepository categoryRepository;
    private final ICategoryEntityMapper categoryEntityMapper;


    @Override
    public void saveCategory(Category category) {
        if(categoryRepository.findBynameCategory(category.getNameCategory()).isPresent()) {
            throw new CategoryAlreadyExistException();
        }
        categoryRepository.save(categoryEntityMapper.toCategoryEntity(category));
    }

    @Override
    public List<Category> getAllCategory() {
        return List.of();
    }

    @Override
    public Category getCategoryById(Long idCategory) {
        return null;
    }

    @Override
    public void updateCategory(Category category) {
        // Use in the future
    }

    @Override
    public void deleteCategoryById(Long idCategory) {
        // Use in the future
    }
}

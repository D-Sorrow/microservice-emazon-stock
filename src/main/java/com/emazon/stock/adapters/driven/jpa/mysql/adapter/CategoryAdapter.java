package com.emazon.stock.adapters.driven.jpa.mysql.adapter;


import com.emazon.stock.adapters.driven.jpa.mysql.entity.CategoryEntity;
import com.emazon.stock.adapters.driven.jpa.mysql.exception.CategoryAlreadyExistException;
import com.emazon.stock.adapters.driven.jpa.mysql.exception.ElementNotFoundException;
import com.emazon.stock.adapters.driven.jpa.mysql.mapper.ICategoryEntityMapper;
import com.emazon.stock.adapters.driven.jpa.mysql.repository.ICategoryRepository;
import com.emazon.stock.domain.model.Category;
import com.emazon.stock.domain.spi.ICategoryPersistencePort;
import com.emazon.stock.domain.util.ResponsePage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static com.emazon.stock.adapters.driven.jpa.mysql.constants.ConstantsJpa.DIRECTION_CATEGORY;

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
    public ResponsePage<Category> getAllCategory(Integer page, Integer size, String sortDirection) {

        Sort.Direction direction = Sort.Direction.fromString(sortDirection.toUpperCase());
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction,DIRECTION_CATEGORY));
        List<CategoryEntity> categories = categoryRepository.findAll(pageable).getContent();
        if (categories.isEmpty()) {
            throw new ElementNotFoundException();
        }

        return new ResponsePage<>(
                size,
                page,
                categoryEntityMapper.toCategoryList(categories)
        );
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

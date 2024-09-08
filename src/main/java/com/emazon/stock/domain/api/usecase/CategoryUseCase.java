package com.emazon.stock.domain.api.usecase;

import com.emazon.stock.domain.api.ICategoryServicePort;
import com.emazon.stock.domain.model.Category;
import com.emazon.stock.domain.spi.ICategoryPersistencePort;
import com.emazon.stock.domain.util.ResponsePage;

import java.util.regex.Pattern;

import static com.emazon.stock.domain.constants.ConstantsDomain.CONTROLLER_REGULAR_EXPRESSION_SORT_DIRECTION;
import static com.emazon.stock.domain.constants.ConstantsDomain.CONTROLLER_SIZE_INVALID_PAGEABLE;

public class CategoryUseCase implements ICategoryServicePort {

    public final ICategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase(ICategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public void saveCategory(Category category) {
        if (category.getDescriptionCategory() == null || category.getNameCategory() == null) {
            throw new IllegalArgumentException();
        }
        if(category.getDescriptionCategory().isEmpty() || category.getNameCategory().isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.categoryPersistencePort.saveCategory(category);
    }

    @Override
    public ResponsePage<Category> getAllCategory(Integer page, Integer size, String sortDirection) {

        Pattern patternSort = Pattern.compile(CONTROLLER_REGULAR_EXPRESSION_SORT_DIRECTION);

        if(!patternSort.matcher(sortDirection).find()){
            throw new IllegalArgumentException();
        }
        if (page < CONTROLLER_SIZE_INVALID_PAGEABLE || size < CONTROLLER_SIZE_INVALID_PAGEABLE) {
            throw new IllegalArgumentException();
        }
        return categoryPersistencePort.getAllCategory(page, size, sortDirection);
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

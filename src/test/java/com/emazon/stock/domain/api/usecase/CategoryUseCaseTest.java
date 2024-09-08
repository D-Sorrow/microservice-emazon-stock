package com.emazon.stock.domain.api.usecase;

import com.emazon.stock.constants.DataProviderCategory;
import com.emazon.stock.constants.DataProviderPage;
import com.emazon.stock.adapters.driven.jpa.mysql.adapter.CategoryAdapter;
import com.emazon.stock.domain.model.Category;
import com.emazon.stock.domain.util.ResponsePage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoryUseCaseTest {


    @Mock
    private CategoryAdapter categoryAdapter;

    @InjectMocks
    private CategoryUseCase categoryUseCase;


    @Test
    void saveCategory() {
        this.categoryUseCase.saveCategory(DataProviderCategory.categoryMock());

        ArgumentCaptor<Category> categoryArgumentCaptor = ArgumentCaptor.forClass(Category.class);
        verify(this.categoryAdapter).saveCategory(categoryArgumentCaptor.capture());

        assertEquals(DataProviderCategory.categoryMock().getIdCategory(), categoryArgumentCaptor.getValue().getIdCategory());
        assertEquals(DataProviderCategory.categoryMock().getNameCategory(), categoryArgumentCaptor.getValue().getNameCategory());
        assertEquals(DataProviderCategory.categoryMock().getDescriptionCategory(), categoryArgumentCaptor.getValue().getDescriptionCategory());

    }

    @Test
    void findAllCategories() {
        when(categoryAdapter.getAllCategory(DataProviderCategory.pageableMock().getPageNumber(),
                DataProviderCategory.pageableMock().getPageSize(), "DESC"))
                .thenReturn(DataProviderPage.responsePageCategoryMock());

        ResponsePage<Category> categoryResponsePage = categoryAdapter.getAllCategory(DataProviderCategory.pageableMock().getPageNumber(),
                DataProviderCategory.pageableMock().getPageSize(), "DESC");
        assertNotNull(categoryResponsePage);
        assertFalse(categoryResponsePage.getCollection().isEmpty());
        assertNotNull(categoryResponsePage.getPages());
        assertNotNull(categoryResponsePage.getSize());
        assertEquals(DataProviderCategory.categoryListMock().get(1).getNameCategory(), categoryResponsePage.getCollection().get(0).getNameCategory());
    }
}
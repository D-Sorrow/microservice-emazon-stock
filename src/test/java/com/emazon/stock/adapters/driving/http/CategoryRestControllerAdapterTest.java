package com.emazon.stock.adapters.driving.http;

import com.emazon.stock.constants.DataProviderCategory;
import com.emazon.stock.constants.DataProviderPage;
import com.emazon.stock.adapters.driving.http.mapper.ICategoryRequestMapper;
import com.emazon.stock.adapters.driving.http.mapper.ICategoryResponseMapper;
import com.emazon.stock.domain.api.ICategoryServicePort;
import com.emazon.stock.domain.model.Category;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class CategoryRestControllerAdapterTest {

    private MockMvc mockMvc;

    @Mock
    private ICategoryServicePort categoryServicePort;

    @Mock
    private ICategoryRequestMapper categoryRequestMapper;

    @Mock
    private ICategoryResponseMapper categoryResponseMapper;

    @InjectMocks
    private CategoryRestControllerAdapter categoryRestControllerAdapter;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(categoryRestControllerAdapter).build();
    }

    @Test
    void addCategoryTest() throws Exception {

        Category category = new Category();
        when(categoryRequestMapper.addRequestToCategory(DataProviderCategory.addCategoryRequestMock())).thenReturn(category);
        doNothing().when(categoryServicePort).saveCategory(any(Category.class));

        String addCategoryJson = new ObjectMapper().writeValueAsString(DataProviderCategory.addCategoryRequestMock());

        MockHttpServletRequestBuilder requestBuilder = post("/category/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(addCategoryJson);

        mockMvc.perform(requestBuilder).andExpect(status().isCreated());

    }

    @Test
    void getAllCategoriesTest() throws Exception {


        when(categoryServicePort.getAllCategory(0,7,"asc"))
                .thenReturn(DataProviderPage.responsePageCategoryMock());

        ResultActions resultActions = this.mockMvc.perform(get("/category/getAllCategory")
                .contentType(MediaType.APPLICATION_JSON)
                .param("page", "0")
                .param("size", "7")
                .param("sortDirection", "asc")

        );

        resultActions.andExpect(status().isOk());



    }

}
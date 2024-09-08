package com.emazon.stock.adapters.driving.http;

import com.emazon.stock.constants.DataProviderBrand;
import com.emazon.stock.adapters.driving.http.mapper.IBrandRequestMapper;
import com.emazon.stock.adapters.driving.http.mapper.IBrandResponseMapper;
import com.emazon.stock.constants.DataProviderPage;
import com.emazon.stock.domain.api.IBrandServicePort;
import com.emazon.stock.domain.model.Brand;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class BrandRestControllerAdapterTest {

    @Mock
    private IBrandServicePort brandService;

    @Mock
    private IBrandRequestMapper brandRequestMapper;

    @Mock
    private IBrandResponseMapper brandResponseMapper;

    @InjectMocks
    private BrandRestControllerAdapter brandRestControllerAdapter;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(brandRestControllerAdapter).build();
    }

    @Test
    void addBrand() throws Exception {
        Brand brand = new Brand();
        when(brandRequestMapper.addRequestBrand(DataProviderBrand.addBrandMock())).thenReturn(brand);
        doNothing().when(brandService).saveBrand(any(Brand.class));

        String addBrandJson = new ObjectMapper().writeValueAsString(DataProviderBrand.addBrandMock());

        MockHttpServletRequestBuilder requestBuilder = post("/brand/")
                .content(addBrandJson)
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder).andExpect(status().isCreated());
    }

    @Test
    void getAllBrands() throws Exception {
        when(brandService.getAllBrands(0,7,"asc"))
                .thenReturn(DataProviderPage.responsePageBrandMock());

        ResultActions resultActions = mockMvc.perform(get("/brand/getAllBrands")
                .contentType(MediaType.APPLICATION_JSON)
                .param("page", "0")
                .param("size", "7")
                .param("sortDirection", "asc")

        );

        resultActions.andExpect(status().isOk());
    }
}
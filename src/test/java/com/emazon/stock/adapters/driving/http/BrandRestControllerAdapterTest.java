package com.emazon.stock.adapters.driving.http;

import com.emazon.stock.DataProviderBrand;
import com.emazon.stock.DataProviderCategory;
import com.emazon.stock.adapters.driving.http.mapper.IBrandRequestMapper;
import com.emazon.stock.adapters.driving.http.mapper.IBrandResponseMapper;
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
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
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
}
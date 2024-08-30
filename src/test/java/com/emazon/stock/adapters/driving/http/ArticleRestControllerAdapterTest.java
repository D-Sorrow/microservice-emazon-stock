package com.emazon.stock.adapters.driving.http;

import com.emazon.stock.DataProviderArticle;
import com.emazon.stock.adapters.driving.http.dto.request.AddArticleRequest;
import com.emazon.stock.adapters.driving.http.mapper.IArticleRequestMapper;
import com.emazon.stock.domain.api.IArticleServicePort;
import com.emazon.stock.domain.model.Article;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
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
class ArticleRestControllerAdapterTest {
    @Mock
    private IArticleServicePort articleServicePort;

    @Mock
    private IArticleRequestMapper articleRequestMapper;

    @InjectMocks
    private ArticleRestControllerAdapter articleRestControllerAdapter;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(articleRestControllerAdapter).build();
    }

    @Test
    void addArticle() throws Exception {
        Article article = new Article();

        when(articleRequestMapper.addRequestToArticle(DataProviderArticle.addArticleRequestMock())).thenReturn(article);
        doNothing().when(articleServicePort).saveArticle(article);

        String mapArticleJson = new ObjectMapper().writeValueAsString(article);

        MockHttpServletRequestBuilder requestBuilder = post("/article/")
                .content(mapArticleJson)
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder).andExpect(status().isCreated());
    }
}
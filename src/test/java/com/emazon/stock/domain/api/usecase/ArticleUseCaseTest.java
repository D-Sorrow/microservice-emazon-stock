package com.emazon.stock.domain.api.usecase;

import com.emazon.stock.DataProviderArticle;
import com.emazon.stock.adapters.driven.jpa.mysql.adapter.ArticleAdapter;
import com.emazon.stock.domain.model.Article;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ArticleUseCaseTest {

    @Mock
    private ArticleAdapter articleAdapter;

    @InjectMocks
    private ArticleUseCase articleUseCase;

    @Test
    void saveArticleTest() {

        this.articleUseCase.saveArticle(DataProviderArticle.articleMock());

        ArgumentCaptor<Article> articleCaptor = ArgumentCaptor.forClass(Article.class);
        verify(this.articleAdapter).saveArticle(articleCaptor.capture());


        assertEquals(DataProviderArticle.articleMock().getNameArticle(), articleCaptor.getValue().getNameArticle());
        assertEquals(DataProviderArticle.articleMock().getDescriptionArticle(), articleCaptor.getValue().getDescriptionArticle());

    }

}
package com.emazon.stock.domain.api.usecase;

import com.emazon.stock.constants.DataProviderArticle;
import com.emazon.stock.adapters.driven.jpa.mysql.adapter.ArticleAdapter;
import com.emazon.stock.domain.model.Article;
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

    @Test
    void getArticleTest() {

        when(articleAdapter.getArticles(DataProviderArticle.PAGE,
                DataProviderArticle.SIZE_ARTICLE, DataProviderArticle.SORT_DIRECTION_ARTICLE,
                DataProviderArticle.SORT_BY)).thenReturn(DataProviderArticle.getResponseArticlePage());

        ResponsePage<Article> articleResponsePage = articleAdapter.getArticles(DataProviderArticle.PAGE,
                DataProviderArticle.SIZE_ARTICLE, DataProviderArticle.SORT_DIRECTION_ARTICLE,
                DataProviderArticle.SORT_BY);

        assertNotNull(articleResponsePage);
        assertFalse(articleResponsePage.getCollection().isEmpty());
        assertEquals(DataProviderArticle.articlesListMock().getClass(), articleResponsePage.getCollection().getClass());

    }

}
package com.emazon.stock.domain.spi;

import com.emazon.stock.domain.model.Article;
import com.emazon.stock.domain.util.ResponsePage;

import java.util.List;

public interface IArticlePersistencePort {


    void saveArticle(Article article);

    ResponsePage<Article> getArticles(int page, int size, String sortDirection, String sortBy);

    void updateStockArticle(Long articleId, Integer quantity);
}

package com.emazon.stock.domain.spi;

import com.emazon.stock.domain.model.Article;

import java.util.List;

public interface IArticlePersistencePort {


    void saveArticle(Article article);

    List<Article> getArticles();

    Article getArticle(String id);

    void deleteArticle(String id);

    void updateArticle(Article article);
}

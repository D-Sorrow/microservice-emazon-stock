package com.emazon.stock.domain.api;

import com.emazon.stock.domain.model.Article;

import java.util.List;

public interface IArticleServicePort {

    void saveArticle(Article article);

    List<Article> getArticles();

    Article getArticle(String id);

    void deleteArticle(String id);

    void updateArticle(Article article);
}

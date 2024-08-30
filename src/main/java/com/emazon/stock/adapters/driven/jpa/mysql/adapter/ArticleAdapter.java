package com.emazon.stock.adapters.driven.jpa.mysql.adapter;

import com.emazon.stock.adapters.driven.jpa.mysql.mapper.IArticleEntityMapper;
import com.emazon.stock.adapters.driven.jpa.mysql.repository.IArticleRepository;
import com.emazon.stock.domain.model.Article;
import com.emazon.stock.domain.spi.IArticlePersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ArticleAdapter implements IArticlePersistencePort {

    private final IArticleRepository articleRepository;
    private final IArticleEntityMapper articleEntityMapper;

    @Override
    public void saveArticle(Article article) {

        this.articleRepository.save(articleEntityMapper.toArticleEntity(article));
    }

    @Override
    public List<Article> getArticles() {
        return List.of();
    }

    @Override
    public Article getArticle(String id) {
        return null;
    }

    @Override
    public void deleteArticle(String id) {

    }

    @Override
    public void updateArticle(Article article) {

    }
}

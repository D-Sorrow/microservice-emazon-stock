package com.emazon.stock.adapters.driven.jpa.mysql.adapter;

import com.emazon.stock.adapters.driven.jpa.mysql.entity.ArticleEntity;
import com.emazon.stock.adapters.driven.jpa.mysql.exception.ElementNotFoundException;
import com.emazon.stock.adapters.driven.jpa.mysql.mapper.IArticleEntityMapper;
import com.emazon.stock.adapters.driven.jpa.mysql.repository.IArticleRepository;
import com.emazon.stock.domain.model.Article;
import com.emazon.stock.domain.spi.IArticlePersistencePort;
import com.emazon.stock.domain.util.ResponsePage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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
    public ResponsePage<Article> getArticles(int page, int size,String sortDirection, String sortBy) {

        Sort.Direction direction = Sort.Direction.fromString(sortDirection.toUpperCase());
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));
        List<ArticleEntity> articleEntities = articleRepository.findAll(pageable).getContent();
        if (articleEntities.isEmpty()) {
            throw new ElementNotFoundException();
        }
        return new ResponsePage<>(
                size,
                page,
                sortBy,
                articleEntityMapper.toArticleList(articleEntities)
        );
    }

    @Override
    public void updateStockArticle(Long articleId, Integer quantity) {
        ArticleEntity articleEntity = articleRepository.findByIdArticle(articleId);
        if (articleEntity == null) {
            throw new ElementNotFoundException();
        }

        articleEntity.setStock(articleEntity.getStock() + quantity);
        articleRepository.save(articleEntity);
    }
}

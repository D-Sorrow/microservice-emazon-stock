package com.emazon.stock.adapters.driven.jpa.mysql.repository;

import com.emazon.stock.adapters.driven.jpa.mysql.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IArticleRepository extends JpaRepository<ArticleEntity, Long> {
    ArticleEntity findByIdArticle(Long idArticle);
}

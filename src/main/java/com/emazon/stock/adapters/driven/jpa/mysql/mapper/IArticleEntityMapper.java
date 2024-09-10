package com.emazon.stock.adapters.driven.jpa.mysql.mapper;

import com.emazon.stock.adapters.driven.jpa.mysql.constants.ConstantsJpa;
import com.emazon.stock.adapters.driven.jpa.mysql.entity.ArticleEntity;
import com.emazon.stock.adapters.driven.jpa.mysql.entity.CategoryEntity;
import com.emazon.stock.domain.model.Article;
import com.emazon.stock.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Mapper(componentModel ="spring", uses = {ICategoryEntityMapper.class, IBrandEntityMapper.class})
public interface IArticleEntityMapper {

    @Mapping(source = ConstantsJpa.ID_ARTICLE, target = ConstantsJpa.ID_ARTICLE)
    @Mapping(source = ConstantsJpa.NAME_ARTICLE, target = ConstantsJpa.NAME_ARTICLE)
    @Mapping(source = ConstantsJpa.DESCRIPTION_ARTICLE, target = ConstantsJpa.DESCRIPTION_ARTICLE)
    @Mapping(source = ConstantsJpa.STOCK, target = ConstantsJpa.STOCK)
    @Mapping(source = ConstantsJpa.PRICE, target = ConstantsJpa.PRICE)
    Article toArticle(ArticleEntity articleEntity);

    @Mapping(target = ConstantsJpa.ID_ARTICLE, ignore = true)
    @Mapping(source = ConstantsJpa.NAME_ARTICLE, target = ConstantsJpa.NAME_ARTICLE)
    @Mapping(source = ConstantsJpa.DESCRIPTION_ARTICLE, target = ConstantsJpa.DESCRIPTION_ARTICLE)
    @Mapping(source = ConstantsJpa.STOCK, target = ConstantsJpa.STOCK)
    @Mapping(source = ConstantsJpa.PRICE, target = ConstantsJpa.PRICE)
    @Mapping(source = ConstantsJpa.CATEGORIES, target = ConstantsJpa.CATEGORIES)
    ArticleEntity toArticleEntity(Article article);
    List<Article> toArticleList(List<ArticleEntity> articlesEntities);
}

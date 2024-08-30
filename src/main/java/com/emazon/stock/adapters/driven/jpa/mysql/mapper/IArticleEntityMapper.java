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

@Mapper(componentModel ="spring")
public interface IArticleEntityMapper {

    @Mapping(source = ConstantsJpa.ID_ARTICLE, target = ConstantsJpa.ID_ARTICLE)
    @Mapping(source = ConstantsJpa.NAME_ARTICLE, target = ConstantsJpa.NAME_ARTICLE)
    @Mapping(source = ConstantsJpa.DESCRIPTION_ARTICLE, target = ConstantsJpa.DESCRIPTION_ARTICLE)
    @Mapping(source = ConstantsJpa.STOCK, target = ConstantsJpa.STOCK)
    @Mapping(source = ConstantsJpa.PRICE, target = ConstantsJpa.PRICE)
    //@Mapping(source = "categories", target = "categories")
    Article toArticle(ArticleEntity articleEntity);

    @Mapping(target = ConstantsJpa.ID_ARTICLE, ignore = true)
    @Mapping(source = ConstantsJpa.NAME_ARTICLE, target = ConstantsJpa.NAME_ARTICLE)
    @Mapping(source = ConstantsJpa.DESCRIPTION_ARTICLE, target = ConstantsJpa.DESCRIPTION_ARTICLE)
    @Mapping(source = ConstantsJpa.STOCK, target = ConstantsJpa.STOCK)
    @Mapping(source = ConstantsJpa.PRICE, target = ConstantsJpa.PRICE)
    @Mapping(source = ConstantsJpa.CATEGORIES, target = ConstantsJpa.CATEGORIES, qualifiedByName = ConstantsJpa.MAP_CATEGORY_ENTITY)
    ArticleEntity toArticleEntity(Article article);
    List<ArticleEntity> toArticleEntitiesList(List<Article> articles);

    @Named(ConstantsJpa.MAP_CATEGORY_ENTITY)
    default Set<CategoryEntity> toArticleEntitiesSet(List<Category> category) {
        Set<CategoryEntity> categoryEntitySet = new HashSet<>();
        if (!category.isEmpty()) {
            for (Category categoryInd : category) {
                CategoryEntity categoryEntity = new CategoryEntity();
                categoryEntity.setIdCategory(categoryInd.getIdCategory());
                categoryEntity.setNameCategory(categoryInd.getNameCategory());
                categoryEntity.setDescriptionCategory(categoryInd.getDescriptionCategory());

                categoryEntitySet.add(categoryEntity);
            }
        }
        return categoryEntitySet;
    }
}

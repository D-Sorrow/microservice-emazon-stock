package com.emazon.stock.adapters.driving.http.mapper;

import com.emazon.stock.adapters.driving.http.dto.request.AddArticleRequest;
import com.emazon.stock.adapters.driving.http.dto.response.ArticleResponse;
import com.emazon.stock.domain.model.Article;
import com.emazon.stock.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.List;

import static com.emazon.stock.adapters.driving.http.constants.ConstantsHttp.*;

@Mapper(componentModel = "spring")
public interface IArticleRequestMapper {

    @Mapping(target = ARTICLE_ID, ignore = true)
    @Mapping(source = ARTICLE_MAP_CATEGORIES_SOURCE, target = ARTICLE_MAP_CATEGORIES_TARGET, qualifiedByName = ARTICLE_MAP_CATEGORIES)
    Article addRequestToArticle(AddArticleRequest articleRequest);

    @Named(ARTICLE_MAP_CATEGORIES)
    default List<Category> longToCategory(List<Long> categories){
        List<Category> categoriesList = new ArrayList<>();
        if(!categories.isEmpty()){
            for(Long idCategory : categories){
                categoriesList.add(new Category(idCategory, idCategory.toString(),idCategory.toString()));
            }
        }
        return categoriesList;
    }
}

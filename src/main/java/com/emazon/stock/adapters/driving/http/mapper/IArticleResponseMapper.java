package com.emazon.stock.adapters.driving.http.mapper;


import com.emazon.stock.adapters.driving.http.dto.response.ArticleResponse;
import com.emazon.stock.domain.model.Article;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import static com.emazon.stock.adapters.driving.http.constants.ConstantsHttp.ARTICLE_ID;

@Mapper(componentModel = "spring")
public interface IArticleResponseMapper {

    @Mapping(target = ARTICLE_ID, ignore = true)
    ArticleResponse toArticleResponse(Article article);
    List<ArticleResponse> toArticleResponses(List<Article> articles);

}

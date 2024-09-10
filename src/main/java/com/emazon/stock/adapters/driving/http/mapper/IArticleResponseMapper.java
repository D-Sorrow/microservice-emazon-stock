package com.emazon.stock.adapters.driving.http.mapper;


import com.emazon.stock.adapters.driving.http.dto.response.ArticleResponse;
import com.emazon.stock.domain.model.Article;
import com.emazon.stock.domain.model.Brand;
import jdk.jfr.Name;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import static com.emazon.stock.adapters.driving.http.constants.ConstantsHttp.ARTICLE_ID;

@Mapper(componentModel = "spring", uses = {ICategoryResponseMapper.class})
public interface IArticleResponseMapper {

    ArticleResponse toArticleResponse(Article article);

    @Mapping(source = "categories", target = "categoryResponseList")
    @Mapping(source = "brand", target = "brandName", qualifiedByName = "MAP_TO_BRAND_NAME")
    List<ArticleResponse> toArticleResponses(List<Article> articles);

    @Name("MAP_TO_BRAND_NAME")
    default String toBrandName(Brand brand) {
        String brandName = brand.getBrandName();
        return brandName == null ? "" : brandName;

    }

}

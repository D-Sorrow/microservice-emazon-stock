package com.emazon.stock.adapters.driving.http;

import com.emazon.stock.adapters.driving.http.constants.ConstantsHttp;
import com.emazon.stock.adapters.driving.http.dto.request.AddArticleRequest;
import com.emazon.stock.adapters.driving.http.dto.response.ArticleResponse;
import com.emazon.stock.adapters.driving.http.mapper.IArticleRequestMapper;
import com.emazon.stock.adapters.driving.http.mapper.IArticleResponseMapper;
import com.emazon.stock.domain.api.IArticleServicePort;
import com.emazon.stock.domain.model.Article;
import com.emazon.stock.domain.util.ResponsePage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleRestControllerAdapter {

    private final IArticleServicePort articleService;
    private final IArticleRequestMapper articleRequestMapper;
    private final IArticleResponseMapper articleResponseMapper;


    @Operation(summary = ConstantsHttp.ADD_ARTICLE_SUMMARY, description = ConstantsHttp.ADD_ARTICLE_DESCRIPTION)
    @ApiResponses(value = {
            @ApiResponse(responseCode = ConstantsHttp.HTTP_STATUS_201, description = ConstantsHttp.ARTICLE_CREATED_SUCCESS),
            @ApiResponse(responseCode = ConstantsHttp.HTTP_STATUS_400, description = ConstantsHttp.INVALID_INPUT_PROVIDED, content = @Content),
            @ApiResponse(responseCode = ConstantsHttp.HTTP_STATUS_500, description = ConstantsHttp.INTERNAL_SERVER_ERROR, content = @Content)
    })
    @PostMapping("/addArticle")
    public ResponseEntity<Void> addArticle(@RequestBody @Valid AddArticleRequest articleRequest) {
        articleService.saveArticle(articleRequestMapper.addRequestToArticle(articleRequest));
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @Operation(summary = ConstantsHttp.GET_ALL_ARTICLES_SUMMARY, description = ConstantsHttp.GET_ALL_ARTICLES_DESCRIPTION)
    @ApiResponses(value = {
            @ApiResponse(responseCode = ConstantsHttp.HTTP_STATUS_200, description = ConstantsHttp.ARTICLES_RETRIEVED_SUCCESS,
                    content = @Content(mediaType = ConstantsHttp.MEDIA_TYPE_JSON,
                            schema = @Schema(implementation = ResponsePage.class))),
            @ApiResponse(responseCode = ConstantsHttp.HTTP_STATUS_400, description = ConstantsHttp.INVALID_INPUT_PROVIDED, content = @Content),
            @ApiResponse(responseCode = ConstantsHttp.HTTP_STATUS_500, description = ConstantsHttp.INTERNAL_SERVER_ERROR, content = @Content)
    })
    @GetMapping("/getAllArticles")
    public ResponsePage<ArticleResponse> getAllArticles(@RequestParam Integer page,
                                                        @RequestParam Integer size,
                                                        @RequestParam String sortDirection,
                                                        @RequestParam String sortBy) {
        ResponsePage<Article> responsePageArticle = articleService.getArticles(page, size, sortDirection, sortBy);
        return new ResponsePage<>(
                responsePageArticle.getSize(),
                responsePageArticle.getPages(),
                responsePageArticle.getSortBy(),
                articleResponseMapper.toArticleResponses(responsePageArticle.getCollection())
        );
    }
}

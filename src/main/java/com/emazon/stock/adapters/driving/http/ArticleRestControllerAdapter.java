package com.emazon.stock.adapters.driving.http;

import com.emazon.stock.adapters.driving.http.dto.request.AddArticleRequest;
import com.emazon.stock.adapters.driving.http.dto.response.ArticleResponse;
import com.emazon.stock.adapters.driving.http.mapper.IArticleRequestMapper;
import com.emazon.stock.adapters.driving.http.mapper.IArticleResponseMapper;
import com.emazon.stock.domain.api.IArticleServicePort;
import com.emazon.stock.domain.model.Article;
import com.emazon.stock.domain.util.ResponsePage;
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

    @PostMapping("/")
    public ResponseEntity<Void> addArticle(@RequestBody @Valid AddArticleRequest articleRequest) {
        articleService.saveArticle(articleRequestMapper.addRequestToArticle(articleRequest));
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }

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

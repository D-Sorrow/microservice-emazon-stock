package com.emazon.stock.adapters.driving.http;

import com.emazon.stock.adapters.driving.http.dto.request.AddArticleRequest;
import com.emazon.stock.adapters.driving.http.mapper.IArticleRequestMapper;
import com.emazon.stock.domain.api.IArticleServicePort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleRestControllerAdapter {

    private final IArticleServicePort articleService;
    private final IArticleRequestMapper articleRequestMapper;

    @PostMapping("/")
    public ResponseEntity<Void> addArticle(@RequestBody @Valid AddArticleRequest articleRequest) {
        articleService.saveArticle(articleRequestMapper.addRequestToArticle(articleRequest));
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

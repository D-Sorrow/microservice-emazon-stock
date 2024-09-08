package com.emazon.stock.adapters.driving.http.dto.response;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ArticleResponse {


    private Long idArticle;

    private String nameArticle;

    private String descriptionArticle;

    private Integer stock;

    private Float price;
}

package com.emazon.stock.adapters.driving.http.dto.response;

import com.emazon.stock.domain.model.Brand;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ArticleResponse {


    private Long idArticle;

    private String nameArticle;

    private String descriptionArticle;

    private Integer stock;

    private Float price;

    private String brand;

    private List<CategoryResponse> categories;
}

package com.emazon.stock.adapters.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryResponse {

    private Long idCategory;
    private String nameCategory;
    private String descriptionCategory;
}

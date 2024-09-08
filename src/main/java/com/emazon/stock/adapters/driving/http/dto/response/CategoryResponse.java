package com.emazon.stock.adapters.driving.http.dto.response;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryResponse {

    private String nameCategory;

    private String descriptionCategory;
}

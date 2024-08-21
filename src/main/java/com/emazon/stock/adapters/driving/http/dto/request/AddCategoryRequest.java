package com.emazon.stock.adapters.driving.http.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddCategoryRequest {

    private String nameCategory;
    private String descriptionCategory;
}

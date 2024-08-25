package com.emazon.stock.adapters.driving.http.dto.response;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BrandResponse {


    private Long brandId;

    @Valid
    private String brandName;

    @Valid
    private String brandDescription;
}

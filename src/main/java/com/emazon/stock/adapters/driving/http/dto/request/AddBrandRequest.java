package com.emazon.stock.adapters.driving.http.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddBrandRequest {

    @NotBlank(message = "Name is required")
    @Size(max = 50, message = "Name cannot be more than 50 characters")
    private String brandName;

    @NotBlank(message = "Name is required")
    @Size(max = 120, message = "Name cannot be more than 120 characters")
    private String brandDescription;
}

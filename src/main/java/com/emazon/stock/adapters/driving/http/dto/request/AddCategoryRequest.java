package com.emazon.stock.adapters.driving.http.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import static com.emazon.stock.adapters.driving.http.constants.ConstantsHttp.*;


@Data
@AllArgsConstructor
public class AddCategoryRequest {

    @NotBlank(message = CATEGORY_NAME_REQUIRED_MESSAGE)
    @NotNull
    @Size(max = CATEGORY_NAME_MAX_LENGTH, message = CATEGORY_NAME_SIZE_INVALID_MESSAGE)
    private String nameCategory;

    @NotNull
    @NotBlank(message = CATEGORY_DESCRIPTION_REQUIRED_MESSAGE)
    @Size(max = CATEGORY_DESCRIPTION_MAX_LENGTH, message = CATEGORY_DESCRIPTION_SIZE_INVALID_MESSAGE)
    private String descriptionCategory;
}

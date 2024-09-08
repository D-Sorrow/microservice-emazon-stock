package com.emazon.stock.adapters.driving.http.dto.request;

import com.emazon.stock.adapters.driving.http.constants.ConstantsHttp;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import static com.emazon.stock.adapters.driving.http.constants.ConstantsHttp.*;

@Data
@AllArgsConstructor
public class AddBrandRequest {

    @NotBlank(message = BRAND_NAME_REQUIRED_MESSAGE)
    @NotNull
    @Size(max = ConstantsHttp.BRAND_NAME_MAX_LENGTH, message = BRAND_NAME_SIZE_INVALID)
    private String brandName;

    @NotBlank(message = BRAND_NAME_REQUIRED_MESSAGE)
    @NotNull
    @Size(max = ConstantsHttp.BRAND_DESCRIPTION_MAX_LENGTH, message = BRAND_DESCRIPTION_SIZE_INVALID)
    private String brandDescription;
}

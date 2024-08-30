package com.emazon.stock.adapters.driving.http.dto.request;

import com.emazon.stock.adapters.driving.http.constants.ConstantsHttp;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

import static com.emazon.stock.adapters.driving.http.constants.ConstantsHttp.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddArticleRequest {

    private Long idArticle;

    @NotNull(message = ARTICLE_NAME_CANNOT_BE_NULL_MESSAGE)
    @NotBlank(message = ARTICLE_NAME_REQUIRED_MESSAGE)
    @Size(min = 1, max = ConstantsHttp.ARTICLE_NAME_MAX_LENGTH)
    private String nameArticle;

    @NotNull(message = ARTICLE_DESCRIPTION_CANNOT_BE_NULL_MESSAGE)
    @NotBlank(message = ARTICLE_DESCRIPTION_REQUIRED_MESSAGE)
    @Size(min = 1, max = ConstantsHttp.ARTICLE_DESCRIPTION_MAX_LENGTH)
    private String descriptionArticle;

    @NotNull(message = ARTICLE_STOCK_CANNOT_BE_NULL_MESSAGE)
    @NotBlank(message = ARTICLE_STOCK_REQUIRED_MESSAGE)
    private Integer stock;

    @NotNull(message = ARTICLE_PRICE_CANNOT_BE_NULL_MESSAGE)
    @NotBlank(message = ARTICLE_PRICE_REQUIRED_MESSAGE)
    private BigDecimal price;

    @NotNull
    private List<Long> categories;

}

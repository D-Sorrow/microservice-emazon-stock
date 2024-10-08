package com.emazon.stock.constants;

import com.emazon.stock.adapters.driving.http.dto.request.AddArticleRequest;
import com.emazon.stock.domain.model.Article;
import com.emazon.stock.domain.model.Brand;
import com.emazon.stock.domain.model.Category;
import com.emazon.stock.domain.util.ResponsePage;

import java.math.BigDecimal;
import java.util.List;

public class DataProviderArticle {

    public static final int PAGE = 0;
    public static final int SIZE_ARTICLE = 5;
    public static final String SORT_BY = "nameArticle";
    public static final String SORT_DIRECTION_ARTICLE = "ASC";

    public static List<Article> articlesListMock(){
        return List.of(
                new Article(
                        1L,
                        "Smartphone X12",
                        "High-end smartphone with 128GB storage and 5G connectivity.",
                        150,
                        new BigDecimal("799.99"),
                        new Brand(),
                        List.of(
                                new Category(1L, "Electronics", "Devices and gadgets"),
                                new Category(2L, "Mobile Phones", "Smartphones and accessories")
                        )
                ),
                new Article(
                        2L,
                        "Men's Denim Jacket",
                        "Classic blue denim jacket for men, size M.",
                        200,
                        new BigDecimal("59.99"),
                        new Brand(),
                        List.of(
                                new Category(3L, "Clothing", "Apparel and accessories"),
                                new Category(4L, "Men's Fashion", "Men's clothing and accessories")
                        )
                ),
                new Article(
                        3L,
                        "Organic Almonds",
                        "Pack of 500g organic almonds, gluten-free and non-GMO.",
                        300,
                        new BigDecimal("12.50"),
                        new Brand(),
                        List.of(
                                new Category(5L, "Groceries", "Food and beverages"),
                                new Category(6L, "Nuts & Seeds", "Various nuts and seeds")
                        )
                ),
                new Article(
                        4L,
                        "Wooden Coffee Table",
                        "Solid oak wood coffee table with a modern design.",
                        50,
                        new BigDecimal("149.99"),
                        new Brand(),
                        List.of(
                                new Category(7L, "Furniture", "Home and office furniture"),
                                new Category(8L, "Living Room Furniture", "Furniture for the living room")
                        )
                )
        );
    }

    public static ResponsePage<Article> getResponseArticlePage(){

        return new ResponsePage<Article>(
                7,
                0,
                DataProviderCategory.NAME_ARTICLE,
                articlesListMock()
        );
    }

    public static Article articleMock(){
        return articlesListMock().get(0);
    }

    public static AddArticleRequest addArticleRequestMock(){
        return new AddArticleRequest();
    }
}

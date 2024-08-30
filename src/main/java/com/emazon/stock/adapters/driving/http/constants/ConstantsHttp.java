package com.emazon.stock.adapters.driving.http.constants;

public class ConstantsHttp {
    private ConstantsHttp() {}
    // Constants Category
    public static final String CATEGORY_NAME_REQUIRED_MESSAGE = "Name is required";
    public static final String CATEGORY_DESCRIPTION_REQUIRED_MESSAGE = "Description is required";
    public static final String CATEGORY_NAME_SIZE_INVALID_MESSAGE = "Name cannot be more than 50 characters";
    public static final String CATEGORY_DESCRIPTION_SIZE_INVALID_MESSAGE = "Description cannot be more than 90 characters";
    public static final int CATEGORY_NAME_MAX_LENGTH = 50;
    public static final int CATEGORY_DESCRIPTION_MAX_LENGTH = 90;

    // Constants Brand
    public static final String BRAND_NAME_REQUIRED_MESSAGE = "Name is required";
    public static final String BRAND_NAME_SIZE_INVALID = "Name cannot be more than 50 characters";
    public static final String BRAND_DESCRIPTION_SIZE_INVALID = "Name cannot be more than 120 characters";
    public static final int BRAND_NAME_MAX_LENGTH = 50;
    public static final int BRAND_DESCRIPTION_MAX_LENGTH = 120;

    // Constants Article
    public static final String ARTICLE_NAME_REQUIRED_MESSAGE = "Name is required";
    public static final String ARTICLE_NAME_CANNOT_BE_NULL_MESSAGE = "Name cannot be null";
    public static final String ARTICLE_DESCRIPTION_REQUIRED_MESSAGE = "Description is required";
    public static final String ARTICLE_DESCRIPTION_CANNOT_BE_NULL_MESSAGE = "Description cannot be null";
    public static final String ARTICLE_STOCK_REQUIRED_MESSAGE = "Stock is required";
    public static final String ARTICLE_STOCK_CANNOT_BE_NULL_MESSAGE = "Stock cannot be null";
    public static final String ARTICLE_PRICE_REQUIRED_MESSAGE = "Price is required";
    public static final String ARTICLE_PRICE_CANNOT_BE_NULL_MESSAGE = "Price cannot be null";
    public static final int ARTICLE_NAME_MAX_LENGTH = 120;
    public static final int ARTICLE_DESCRIPTION_MAX_LENGTH = 120;

    // Constants Mapper
    public static final String ID_CATEGORY = "idCategory";
    public static final String BRAND_ID = "brandId";
    public static final String  ARTICLE_ID = "idArticle";
    public static final String ARTICLE_MAP_CATEGORIES =  "map_categories";
    public static final String ARTICLE_MAP_CATEGORIES_SOURCE =  "categories";
    public static final String ARTICLE_MAP_CATEGORIES_TARGET =  "categories";

    //Constants Controllers
    public static final String CATEGORY_CONTROLLER_REGULAR_EXPRESSION = "^(?i)(asc|desc)$";
    public static final int CATEGORY_CONTROLLER_SIZE_INVALID = 0;

}

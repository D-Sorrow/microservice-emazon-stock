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
    public static final String MAP_TO_BRAND_NAME = "MAP_TO_BRAND_NAME";
    public static final String MAP_TO_CATEGORY_LIST = "categoryResponseList";


    // Summaries
    public static final String ADD_ARTICLE_SUMMARY = "Add a new article";
    public static final String GET_ALL_ARTICLES_SUMMARY = "Get all articles";

    // Descriptions
    public static final String ADD_ARTICLE_DESCRIPTION = "Creates a new article in the system";
    public static final String GET_ALL_ARTICLES_DESCRIPTION = "Retrieve all articles with pagination and sorting options";

    // Response descriptions
    public static final String ARTICLE_CREATED_SUCCESS = "Article created successfully";
    public static final String ARTICLES_RETRIEVED_SUCCESS = "Articles retrieved successfully";
    public static final String INVALID_INPUT_PROVIDED = "Invalid input provided";
    public static final String INVALID_PAGINATION_SORTING = "Invalid pagination or sorting parameters";
    public static final String INTERNAL_SERVER_ERROR = "Internal server error";

    // Media types
    public static final String MEDIA_TYPE_JSON = "application/json";

    // HTTP Status Codes
    public static final String HTTP_STATUS_200 = "200";
    public static final String HTTP_STATUS_201 = "201";
    public static final String HTTP_STATUS_400 = "400";
    public static final String HTTP_STATUS_500 = "500";

    // Summaries
    public static final String ADD_BRAND_SUMMARY = "Add a new brand";
    public static final String GET_ALL_BRANDS_SUMMARY = "Get all brands";

    // Descriptions
    public static final String ADD_BRAND_DESCRIPTION = "Creates a new brand in the system";
    public static final String GET_ALL_BRANDS_DESCRIPTION = "Retrieve all brands with pagination and sorting options";

    // Response descriptions
    public static final String BRAND_CREATED_SUCCESS = "Brand created successfully";
    public static final String BRANDS_RETRIEVED_SUCCESS = "Brands retrieved successfully";

    // Summaries
    public static final String ADD_CATEGORY_SUMMARY = "Add a new category";
    public static final String GET_ALL_CATEGORIES_SUMMARY = "Get all categories";

    // Descriptions
    public static final String ADD_CATEGORY_DESCRIPTION = "Creates a new category in the system";
    public static final String GET_ALL_CATEGORIES_DESCRIPTION = "Retrieve all categories with pagination and sorting options";

    // Response descriptions
    public static final String CATEGORY_CREATED_SUCCESS = "Category created successfully";
    public static final String CATEGORIES_RETRIEVED_SUCCESS = "Categories retrieved successfully";

}

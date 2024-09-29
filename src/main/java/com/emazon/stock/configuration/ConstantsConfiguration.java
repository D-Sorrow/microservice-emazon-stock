package com.emazon.stock.configuration;

public class ConstantsConfiguration {

    private ConstantsConfiguration() {}

    public static final String EMPTY_FIELD = "The field must not be empty";
    public static final String SIZE_NOT_ALLOWED = "Field size not allowed";
    public static final String BRAND_ALREADY_EXISTS = "The brand already exists";
    public static final String CATEGORY_ALREADY_EXISTS = "The category already exists";
    public static final String ELEMENT_NOT_FOUND = "Element not found";
    public static final String INVALID_ARGUMENT = "Invalid argument provided";


    public static final String URL_AUTHENTICATION_ADD_ARTICLE = "/article/addArticle";
    public static final String URL_AUTHENTICATION_ADD_CATEGORY = "/article/addCategory";
    public static final String URL_AUTHENTICATION_ADD_BRAND = "/brand/addBrand";
    public static final String AUTHENTICATION_GET_ARTICLE_HAS_ROLE = "ADMIN";
}

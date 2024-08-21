package com.emazon.stock.domain.util;

public class DomainConstants {
    private DomainConstants() {
        throw new IllegalStateException("Utility class");
    }
    public enum Field {
        NAME,
        DESCRIPTION
    }
    public static final String FIELD_NAME_NULL_MESSAGE = "Field 'name' cannot be null";
    public static final String FIELD_NAME_EMPTY_MESSAGE = "Field 'name' cannot be empty";
    public static final String FIELD_NAME_INVALID_SIZE = "Field 'name' cannot be greater than 50";
    public static final String FIELD_DESCRIPTION_NULL_MESSAGE = "Field 'description' cannot be null";
    public static final String FIELD_DESCRIPTION_EMPTY_MESSAGE = "Field 'description' cannot be empty";
    public static final String FIELD_DESCRIPTION_INVALID_SIZE = "Field 'description' cannot be greater than 50";
}

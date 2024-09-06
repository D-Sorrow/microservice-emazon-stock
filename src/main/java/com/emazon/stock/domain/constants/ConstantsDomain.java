package com.emazon.stock.domain.constants;

import java.math.BigDecimal;

public class ConstantsDomain {

    private ConstantsDomain() {}

    //Constants Controllers
    public static final String CONTROLLER_REGULAR_EXPRESSION_SORT_DIRECTION = "^(?i)(asc|desc)$";
    public static final int CONTROLLER_SIZE_INVALID_PAGEABLE = 0;
    public static final BigDecimal DATA_NULL_BIG_DECIMAL = null;
    public static final Integer  DATA_NULL_INT = null;
    public static final int SIZE_INVALID_TO_ARTICLE = 3;
}

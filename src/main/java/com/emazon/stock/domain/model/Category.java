package com.emazon.stock.domain.model;


import com.emazon.stock.domain.exception.EmptyFieldException;
import com.emazon.stock.domain.exception.SizeNotAllowedException;
import com.emazon.stock.domain.util.DomainConstants;
import lombok.Value;

import static java.util.Objects.requireNonNull;

public class Category {

    private Long idCategory;
    private String nameCategory;
    private String descriptionCategory;
    public static final int MAX_CATEGORY_NAME_LENGTH = 50;
    public static final int MAX_CATEGORY_DESCRIPTION_LENGTH = 90;

    public Category(Long idCategory, String nameCategory, String descriptionCategory) {

        if(nameCategory.trim().isEmpty()) {
            throw new EmptyFieldException(DomainConstants.Field.NAME.toString());
        }
        if(nameCategory.length() > MAX_CATEGORY_NAME_LENGTH) {
            throw new SizeNotAllowedException(DomainConstants.Field.NAME.toString());
        }
        if(descriptionCategory.trim().isEmpty()) {
            throw new EmptyFieldException(DomainConstants.Field.DESCRIPTION.toString());
        }
        if(descriptionCategory.length() > MAX_CATEGORY_DESCRIPTION_LENGTH) {
            throw new SizeNotAllowedException(DomainConstants.Field.NAME.toString());
        }
        this.idCategory = idCategory;
        this.nameCategory = requireNonNull(nameCategory, DomainConstants.FIELD_NAME_NULL_MESSAGE);
        this.descriptionCategory = requireNonNull(descriptionCategory, DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
    }

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getDescriptionCategory() {
        return descriptionCategory;
    }

    public void setDescriptionCategory(String descriptionCategory) {
        this.descriptionCategory = descriptionCategory;
    }


}
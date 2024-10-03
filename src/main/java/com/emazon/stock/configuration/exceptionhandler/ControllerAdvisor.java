package com.emazon.stock.configuration.exceptionhandler;

import com.emazon.stock.adapters.driven.jpa.mysql.exception.BrandAlreadyExistException;
import com.emazon.stock.adapters.driven.jpa.mysql.exception.CategoryAlreadyExistException;
import com.emazon.stock.adapters.driven.jpa.mysql.exception.ElementNotFoundException;
import com.emazon.stock.configuration.ConstantsConfiguration;
import com.emazon.stock.domain.exception.EmptyFieldException;
import com.emazon.stock.domain.exception.InvalidNumber;
import com.emazon.stock.domain.exception.SizeNotAllowedException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;


@ControllerAdvice
@RequiredArgsConstructor
public class ControllerAdvisor {

    @ExceptionHandler(EmptyFieldException.class)
    public ResponseEntity<ExceptionResponse> handleEmptyFieldException(EmptyFieldException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                String.format(ConstantsConfiguration.EMPTY_FIELD, exception.getMessage()),
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()
        ));
    }
    @ExceptionHandler({SizeNotAllowedException.class})
    public ResponseEntity<ExceptionResponse> handleSizeNotAllowedException(SizeNotAllowedException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                String.format(ConstantsConfiguration.SIZE_NOT_ALLOWED, exception.getMessage()),
                        HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()
        ));
    }
    @ExceptionHandler({BrandAlreadyExistException.class})
    public ResponseEntity<ExceptionResponse> handleBrandAlreadyExist(BrandAlreadyExistException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                String.format(ConstantsConfiguration.BRAND_ALREADY_EXISTS, exception.getMessage()),
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()
        ));
    }
    @ExceptionHandler(CategoryAlreadyExistException.class)
    public ResponseEntity<ExceptionResponse> handleCategoryAlreadyExist(CategoryAlreadyExistException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                String.format(ConstantsConfiguration.CATEGORY_ALREADY_EXISTS, exception.getMessage()),
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()
        ));
    }
    @ExceptionHandler(ElementNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleElementNotFound(ElementNotFoundException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                String.format(ConstantsConfiguration.ELEMENT_NOT_FOUND, exception.getMessage()),
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()
        ));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionResponse> handleIllegalArgument(IllegalArgumentException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                String.format(ConstantsConfiguration.ELEMENT_NOT_FOUND, exception.getMessage()),
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()
        ));
    }

    @ExceptionHandler(InvalidNumber.class)
    public ResponseEntity<ExceptionResponse> handleInvalidNumber(InvalidNumber exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                String.format(ConstantsConfiguration.INVALID_NUMBERS, exception.getMessage()),
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()
        ));
    }

}

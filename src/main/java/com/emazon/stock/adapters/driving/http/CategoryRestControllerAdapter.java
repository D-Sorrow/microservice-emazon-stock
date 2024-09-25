package com.emazon.stock.adapters.driving.http;

import com.emazon.stock.adapters.driven.jpa.mysql.constants.ConstantsJpa;
import com.emazon.stock.adapters.driving.http.constants.ConstantsHttp;
import com.emazon.stock.adapters.driving.http.dto.request.AddCategoryRequest;
import com.emazon.stock.adapters.driving.http.dto.response.CategoryResponse;
import com.emazon.stock.adapters.driving.http.mapper.ICategoryResponseMapper;
import com.emazon.stock.adapters.driving.http.mapper.ICategoryRequestMapper;
import com.emazon.stock.domain.api.ICategoryServicePort;
import com.emazon.stock.domain.model.Category;
import com.emazon.stock.domain.util.ResponsePage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryRestControllerAdapter {

    private final ICategoryServicePort categoryServicePort;
    private final ICategoryRequestMapper categoryRequestMapper;
    private final ICategoryResponseMapper categoryResponseMapper;


    @Operation(summary = ConstantsHttp.ADD_CATEGORY_SUMMARY, description = ConstantsHttp.ADD_CATEGORY_DESCRIPTION)
    @ApiResponses(value = {
            @ApiResponse(responseCode = ConstantsHttp.HTTP_STATUS_201, description = ConstantsHttp.CATEGORY_CREATED_SUCCESS),
            @ApiResponse(responseCode = ConstantsHttp.HTTP_STATUS_400, description = ConstantsHttp.INVALID_INPUT_PROVIDED, content = @Content),
            @ApiResponse(responseCode = ConstantsHttp.HTTP_STATUS_500, description = ConstantsHttp.INTERNAL_SERVER_ERROR, content = @Content)
    })
    @PostMapping("/addCategory")
    public ResponseEntity<Void> addCategory(@RequestBody @Valid AddCategoryRequest request){
        categoryServicePort.saveCategory(categoryRequestMapper.addRequestToCategory(request));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = ConstantsHttp.GET_ALL_CATEGORIES_SUMMARY, description = ConstantsHttp.GET_ALL_CATEGORIES_DESCRIPTION)
    @ApiResponses(value = {
            @ApiResponse(responseCode = ConstantsHttp.HTTP_STATUS_200, description = ConstantsHttp.CATEGORIES_RETRIEVED_SUCCESS,
                    content = @Content(mediaType = ConstantsHttp.MEDIA_TYPE_JSON,
                            schema = @Schema(implementation = ResponsePage.class))),
            @ApiResponse(responseCode = ConstantsHttp.HTTP_STATUS_400, description = ConstantsHttp.INVALID_INPUT_PROVIDED, content = @Content),
            @ApiResponse(responseCode = ConstantsHttp.HTTP_STATUS_500, description = ConstantsHttp.INTERNAL_SERVER_ERROR, content = @Content)
    })
    @GetMapping("/getAllCategory")
    public ResponseEntity<ResponsePage<CategoryResponse>> getAllCategories(@RequestParam  Integer page,
                                                         @RequestParam  Integer size,
                                                         @RequestParam  String sortDirection){
        ResponsePage<Category> categoryResponsePage = categoryServicePort.getAllCategory(page, size, sortDirection);
        return ResponseEntity.ok(
                new ResponsePage<>(
                        categoryResponsePage.getSize(),
                        categoryResponsePage.getPages(),
                        categoryResponsePage.getSortBy(),
                        categoryResponseMapper.toCategoryResponsesList(categoryResponsePage.getCollection())
                )
        );
    }




}

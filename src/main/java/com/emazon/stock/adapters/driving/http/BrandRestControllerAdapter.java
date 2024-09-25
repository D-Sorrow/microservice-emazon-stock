package com.emazon.stock.adapters.driving.http;

import com.emazon.stock.adapters.driven.jpa.mysql.constants.ConstantsJpa;
import com.emazon.stock.adapters.driving.http.constants.ConstantsHttp;
import com.emazon.stock.adapters.driving.http.dto.request.AddBrandRequest;
import com.emazon.stock.adapters.driving.http.dto.response.BrandResponse;
import com.emazon.stock.adapters.driving.http.mapper.IBrandRequestMapper;
import com.emazon.stock.adapters.driving.http.mapper.IBrandResponseMapper;
import com.emazon.stock.domain.api.IBrandServicePort;
import com.emazon.stock.domain.model.Brand;
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

import java.util.List;

@RestController
@RequestMapping("/brand")
@RequiredArgsConstructor
public class BrandRestControllerAdapter {

    private final IBrandServicePort brandService;
    private final IBrandRequestMapper brandRequestMapper;
    private final IBrandResponseMapper brandResponseMapper;

    @Operation(summary = ConstantsHttp.ADD_BRAND_SUMMARY, description = ConstantsHttp.ADD_BRAND_DESCRIPTION)
    @ApiResponses(value = {
            @ApiResponse(responseCode = ConstantsHttp.HTTP_STATUS_201, description = ConstantsHttp.BRAND_CREATED_SUCCESS),
            @ApiResponse(responseCode = ConstantsHttp.HTTP_STATUS_400, description = ConstantsHttp.INVALID_INPUT_PROVIDED, content = @Content),
            @ApiResponse(responseCode = ConstantsHttp.HTTP_STATUS_500, description = ConstantsHttp.INTERNAL_SERVER_ERROR, content = @Content)
    })
    @PostMapping("/addBrand")
    public ResponseEntity<Void> addBrand(@RequestBody @Valid AddBrandRequest addBrandRequest) {
        brandService.saveBrand(brandRequestMapper.addRequestBrand(addBrandRequest));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = ConstantsHttp.GET_ALL_BRANDS_SUMMARY, description = ConstantsHttp.GET_ALL_BRANDS_DESCRIPTION)
    @ApiResponses(value = {
            @ApiResponse(responseCode = ConstantsHttp.HTTP_STATUS_200, description = ConstantsHttp.BRANDS_RETRIEVED_SUCCESS,
                    content = @Content(mediaType = ConstantsHttp.MEDIA_TYPE_JSON,
                            schema = @Schema(implementation = ResponsePage.class))),
            @ApiResponse(responseCode = ConstantsHttp.HTTP_STATUS_400, description = ConstantsHttp.INVALID_PAGINATION_SORTING, content = @Content),
            @ApiResponse(responseCode = ConstantsHttp.HTTP_STATUS_500, description = ConstantsHttp.INTERNAL_SERVER_ERROR, content = @Content)
    })
    @GetMapping("/getAllBrands")
    public ResponsePage<BrandResponse> getAllBrands(@RequestParam @Valid Integer page,
                                                            @RequestParam @Valid Integer size,
                                                            @RequestParam @Valid String sortDirection) {
        ResponsePage<Brand> brandResponsePage = brandService.getAllBrands(page,size,sortDirection);
        return new ResponsePage<>(
                brandResponsePage.getSize(),
                brandResponsePage.getPages(),
                brandResponsePage.getSortBy(),
                brandResponseMapper.toBrandResponseList(brandResponsePage.getCollection())
        );
    }
}

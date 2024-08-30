package com.emazon.stock.adapters.driving.http;

import com.emazon.stock.adapters.driving.http.dto.request.AddCategoryRequest;
import com.emazon.stock.adapters.driving.http.dto.response.CategoryResponse;
import com.emazon.stock.adapters.driving.http.mapper.ICategoryResponseMapper;
import com.emazon.stock.adapters.driving.http.mapper.ICategoryRequestMapper;
import com.emazon.stock.domain.api.ICategoryServicePort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Pattern;

import static com.emazon.stock.adapters.driving.http.constants.ConstantsHttp.CATEGORY_CONTROLLER_REGULAR_EXPRESSION;
import static com.emazon.stock.adapters.driving.http.constants.ConstantsHttp.CATEGORY_CONTROLLER_SIZE_INVALID;


@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryRestControllerAdapter {

    private final ICategoryServicePort categoryServicePort;
    private final ICategoryRequestMapper categoryRequestMapper;
    private final ICategoryResponseMapper categoryResponseMapper;

    @PostMapping("/")
    public ResponseEntity<Void> addCategory(@RequestBody @Valid AddCategoryRequest request){
        categoryServicePort.saveCategory(categoryRequestMapper.addRequestToCategory(request));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("/getAllCategory")
    public ResponseEntity<List<CategoryResponse>> getAllCategories(@RequestParam  Integer page,
                                                                   @RequestParam  Integer size,
                                                                   @RequestParam  String sortDirection){
        Pattern patternSort = Pattern.compile(CATEGORY_CONTROLLER_REGULAR_EXPRESSION);

        if(!patternSort.matcher(sortDirection).find()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        if (page < CATEGORY_CONTROLLER_SIZE_INVALID || size < CATEGORY_CONTROLLER_SIZE_INVALID) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(categoryResponseMapper.toCategoryResponsesList(
                categoryServicePort.getAllCategory(page,size,sortDirection)));
    }




}

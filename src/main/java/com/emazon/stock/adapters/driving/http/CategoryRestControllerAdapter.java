package com.emazon.stock.adapters.driving.http;

import com.emazon.stock.adapters.driving.http.dto.request.AddCategoryRequest;
import com.emazon.stock.adapters.driving.http.dto.response.CategoryResponse;
import com.emazon.stock.adapters.driving.http.mapper.ICategoryResponseMapper;
import com.emazon.stock.adapters.driving.http.mapper.ICategoryRequestMapper;
import com.emazon.stock.domain.api.ICategoryServicePort;
import com.emazon.stock.domain.model.Category;
import com.emazon.stock.domain.util.ResponsePage;
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

    @PostMapping("/")
    public ResponseEntity<Void> addCategory(@RequestBody @Valid AddCategoryRequest request){
        categoryServicePort.saveCategory(categoryRequestMapper.addRequestToCategory(request));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("/getAllCategory")
    public ResponseEntity<ResponsePage<CategoryResponse>> getAllCategories(@RequestParam  Integer page,
                                                         @RequestParam  Integer size,
                                                         @RequestParam  String sortDirection){
        ResponsePage<Category> categoryResponsePage = categoryServicePort.getAllCategory(page, size, sortDirection);
        return ResponseEntity.ok(
                new ResponsePage<>(
                        categoryResponsePage.getSize(),
                        categoryResponsePage.getPages(),
                        categoryResponseMapper.toCategoryResponsesList(categoryResponsePage.getCollection())
                )
        );
    }




}

package com.emazon.stock.adapters.driving.http;

import com.emazon.stock.adapters.driving.http.dto.request.AddBrandRequest;
import com.emazon.stock.adapters.driving.http.dto.response.BrandResponse;
import com.emazon.stock.adapters.driving.http.mapper.IBrandRequestMapper;
import com.emazon.stock.adapters.driving.http.mapper.IBrandResponseMapper;
import com.emazon.stock.domain.api.IBrandServicePort;
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

    @PostMapping("/")
    public ResponseEntity<Void> addBrand(@RequestBody AddBrandRequest addBrandRequest) {
        brandService.saveBrand(brandRequestMapper.addRequestBrand(addBrandRequest));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("/getAllBrands")
    public ResponseEntity<List<BrandResponse>> getAllBrands(@RequestParam Integer page,
                                                            @RequestParam Integer size,
                                                            @RequestParam String sortDirection) {
        return ResponseEntity.ok(brandResponseMapper.toBrandResponseList(
                brandService.getAllBrands(page,size,sortDirection)));
    }
}

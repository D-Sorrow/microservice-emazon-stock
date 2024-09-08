package com.emazon.stock.constants;

import com.emazon.stock.adapters.driving.http.dto.request.AddBrandRequest;
import com.emazon.stock.adapters.driving.http.dto.response.BrandResponse;
import com.emazon.stock.domain.model.Brand;
import com.emazon.stock.domain.util.ResponsePage;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public class DataProviderBrand {

    public static List<Brand> brandListMock(){
        return List.of(
                new Brand(2L, "Nike", "Leading sportswear brand."),
                new Brand(3L, "HP", "Computers and printers."),
                new Brand(4L, "International Business Machines", "A global leader in technology solutions, offering a diverse range of services and products."),
                new Brand(5L, "sony", "Innovative electronics and entertainment."),
                new Brand(6L, "Dell", "Computers, laptops, & accessories."),
                new Brand(7L, "Procter & Gamble", "Consumer goods company with a wide range of products."),
                new Brand(1L, "Apple", "Leading innovator in technology."),
                new Brand(8L, "3M", "Science and technology company."),
                new Brand(9L, "Samsung", "Global electronics and technology company."),
                new Brand(10L, "Microsoft", "Microsoft is a leader in software, solutions that help people and businesses realize their full potential.")

        );
    }
    public static List<BrandResponse> brandResponseList(){
        return List.of(
                new BrandResponse("Nike", "Leading sportswear brand."),
                new BrandResponse("HP", "Computers and printers.")
        );
    }

    public static Brand brandMock(){
        return new Brand(2L, "Nike", "Leading sportswear brand.");
    }

    public static AddBrandRequest addBrandMock(){
        return new AddBrandRequest( "Nike", "Leading sportswear brand.");
    }

    public static Pageable pageableMock(){
        return PageRequest.of(0,
                10,
                Sort.by(Sort.Direction.ASC,"brandName"));
    }
}

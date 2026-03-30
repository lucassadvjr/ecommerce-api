package com.ecomerce.mock.ecommerce_api.mapper;

import com.ecomerce.mock.ecommerce_api.dto.ProductDTO;
import com.ecomerce.mock.ecommerce_api.dto.ProductResponse;

public class ProductMapper {
    public static ProductResponse toResponse (ProductDTO product){
        return new ProductResponse(
                product.getId(),
                product.getTitle(),
                product.getPrice());
    }
}

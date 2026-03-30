package com.ecomerce.mock.ecommerce_api.controller;


import com.ecomerce.mock.ecommerce_api.dto.ProductResponse;
import com.ecomerce.mock.ecommerce_api.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;

    }

    @GetMapping("/products")
    public List<ProductResponse> getProducts() {
        return productService.listProducts();
    }
    @GetMapping("/products/{id}" )
    public ProductResponse getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

}

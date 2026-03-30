package com.ecomerce.mock.ecommerce_api.integration;


import com.ecomerce.mock.ecommerce_api.dto.ProductDTO;
import com.ecomerce.mock.ecommerce_api.dto.ProductResponseDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String URL = "https://dummyjson.com/products";
    public ProductResponseDTO getProducts() {
        return restTemplate.getForObject(URL, ProductResponseDTO.class);
    }
    //retorna product/id - especifico
    public ProductDTO getProductById (Long id ) {
        return restTemplate.getForObject(URL + "/" + id, ProductDTO.class);
    }
}

package com.ecomerce.mock.ecommerce_api.dto;

import lombok.*;

import java.util.List;
@Data

@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDTO {
    private List<ProductDTO> products;
    private Integer total;





}

package com.ecomerce.mock.ecommerce_api.service;


import com.ecomerce.mock.ecommerce_api.dto.ProductDTO;
import com.ecomerce.mock.ecommerce_api.dto.ProductResponse;
import com.ecomerce.mock.ecommerce_api.dto.ProductResponseDTO;
import com.ecomerce.mock.ecommerce_api.exception.ResourceNotFoundException;
import com.ecomerce.mock.ecommerce_api.integration.ProductClient;
import com.ecomerce.mock.ecommerce_api.mapper.ProductMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Camada de serviço responsável pelas regras de negócio relacionadas a produtos.
 *
 * Atua como intermediária entre o controller e a integração externa,
 * garantindo desacoplamento da API externa e conversão para o modelo interno.
 */

@Service
public class ProductService {
    private final ProductClient productClient;

    public ProductService(ProductClient productClient) {
        this.productClient = productClient;
    }
    /**
     * Busca a lista de produtos na API externa e converte para o modelo interno.
     *
     * - Utiliza Optional para evitar NullPointerException
     * - Retorna lista vazia caso a API não retorne dados
     * - Converte ProductDTO (externo) para ProductResponse (interno)
     */
    public List<ProductResponse> listProducts() {
        ProductResponseDTO response = productClient.getProducts();

        List<ProductDTO> products = Optional.ofNullable(response)
                .map(ProductResponseDTO::getProducts)
                .orElse(List.of());

        return products.stream()
                .map(ProductMapper::toResponse)
                .collect(Collectors.toList());
    }

    public ProductResponse getProductById(Long id) {
        try {
            ProductDTO product = productClient.getProductById(id);
            return ProductMapper.toResponse(product);

        } catch (HttpClientErrorException.NotFound e) {
            throw new ResourceNotFoundException("Produto com id " + id + " não encontrado");
        }
    }



}
